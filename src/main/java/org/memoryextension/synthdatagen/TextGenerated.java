package org.memoryextension.synthdatagen;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TextGenerated {
		private String generatedText;

		public String getGeneratedText(){ return generatedText;}
		public void setGeneratedText(String s){ generatedText=s;}
		public void setText(String s){ setGeneratedText(s);}
}

