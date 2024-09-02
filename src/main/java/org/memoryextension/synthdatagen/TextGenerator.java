package org.memoryextension.synthdatagen;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TextGenerator {
	private String text;
	private long seed;
	
	private int nbTokens;
	private int nbSequences;
	
	public TextGenerator(String t, long s, int tk, int seq){
		text=t;
		seed=s;
		nbTokens=tk;
		nbSequences=seq;
	}
	
	public String getText(){ return text;}
	public void setText(String t){ text=t;}

	public long getSeed(){ return seed;}
	public void setSeed(long s){ seed=s;}

	@JsonProperty("maxTokens")
	public int getNbTokens(){ return nbTokens;}
	public void setNbTokens(int tk){ nbTokens=tk;}

	@JsonProperty("nbSeq")
	public int getNbSequences(){ return nbSequences;}
	public void setNbSequences(int seq){ nbSequences=seq;}
}
