package src.main.react.src;


    @RestController
    @RequestMapping("/api")
    public class DebugController {
    
        @PostMapping("/generate-text")
        public ResponseEntity<String> generateText(@RequestBody GenerateRequest request) {
            // Call your LLM API here with request.getInputText(), request.getTokens(), request.getSeed()
            // Return the generated text
            return ResponseEntity.ok(generatedText);
        }
    }
    
    public class GenerateRequest {
        private String inputText;
        private int tokens;
        private int seed;
    
        // Getters and setters
    }
    

