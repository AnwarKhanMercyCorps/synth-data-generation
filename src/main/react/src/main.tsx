import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import App from './App.tsx'
import './index.css'
import React, { useState } from 'react';

const DebugTab = () => {
  const [inputText, setInputText] = useState('');
  const [tokens, setTokens] = useState(50);
  const [seed, setSeed] = useState(1337);
  const [showSettings, setShowSettings] = useState(false);
  const [generatedText, setGeneratedText] = useState('');

  const toggleSettings = () => setShowSettings(!showSettings);
  const resetDefaults = () => {
      setTokens(50);
      setSeed(1337);
  };

  const generateText = async () => {
      // API call to generate text using LLM
      const response = await fetch('/api/generate-text', {
          method: 'POST',
          headers: { 'Content-Type': 'application/json' },
          body: JSON.stringify({ inputText, tokens, seed }),
      });
      const data = await response.json();
      // Process the response to remove incomplete sentences
      const fullText = data.generatedText.trim();
      setGeneratedText(fullText.endsWith('.') ? fullText : fullText.substring(0, fullText.lastIndexOf('.') + 1));
  };

  const generatePigLatin = () => {
      // Convert generated text to Pig Latin
      // You may want to call a backend endpoint or implement this in JS
      // Here is a basic example function
      const pigLatin = (text) => {
          // Pig Latin conversion logic goes here
          return text; // Placeholder for actual conversion
      };

      setGeneratedText(pigLatin(generatedText));
  };

  return (
      <div>
          <h1>Debug</h1>
          <form>
              <input
                  type="text"
                  value={inputText}
                  onChange={(e) => setInputText(e.target.value)}
                  placeholder="Enter starting text"
              />
              <button type="button" onClick={toggleSettings}>
                  {showSettings ? 'Hide Settings' : 'Show Settings'}
              </button>
              {showSettings && (
                  <div>
                      <label>
                          Number of Tokens:
                          <input
                              type="number"
                              value={tokens}
                              onChange={(e) => setTokens(e.target.value)}
                          />
                      </label>
                      <label>
                          Seed:
                          <input
                              type="number"
                              value={seed}
                              onChange={(e) => setSeed(e.target.value)}
                          />
                      </label>
                      <button type="button" onClick={resetDefaults}>
                          Reset to Default
                      </button>
                  </div>
              )}
              <button type="button" onClick={generateText} disabled={!inputText}>
                  Generate Text
              </button>
              <button type="button" onClick={generatePigLatin} disabled={!generatedText}>
                  Generate Pig Latin
              </button>
          </form>
          <div>
              <h2>Generated Text:</h2>
              <p>{generatedText}</p>
          </div>
      </div>
  );
};

export default DebugTab;
createRoot(document.getElementById('root')!).render(
  <StrictMode>

    <App />
  </StrictMode>,
)
