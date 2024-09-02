package org.memoryextension.synthdatagen;

class LLMConfig {
 
 	private long seed;
	private int nbTokens;
	private int nbSequences;
 
	public LLMConfig(){
		seed=51;
		nbTokens=150;
		nbSequences=2;
	}
 
	public long getSeed(){ return seed;}
	public void setSeed(long s){ seed=s;}

	public int getNbTokens(){ return nbTokens;}
	public void setNbTokens(int tk){ nbTokens=tk;}

	public int getNbSequences(){ return nbSequences;}
	public void setNbSequences(int seq){ nbSequences=seq;}
 
	public void SetConfig(LLMConfig cfg){
		setSeed(cfg.getSeed());
	}
 
}
