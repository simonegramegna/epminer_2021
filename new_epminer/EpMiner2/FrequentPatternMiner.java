
class FrequentPatternMiner {
	private 		LinkList outputFP=new LinkList();
	
	
	FrequentPatternMiner(Data data,float minSup){
		Queue fpQueue=new Queue();		
	
		for(int i=0;i<data.getNumberOfAttributes();i++)
		{
			Attribute currentAttribute=data.getAttribute(i);
			for(int j=0;j<((DiscreteAttribute)currentAttribute).getNumberOfDistinctValues();j++){
				DiscreteItem item=new DiscreteItem( 
						(DiscreteAttribute)currentAttribute, 
						((DiscreteAttribute)currentAttribute).getValue(j));
				FrequentPattern fp=new FrequentPattern();
				fp.addItem(item);
				fp.setSupport(fp.computeSupport(data));
				if(fp.getSupport()>=minSup){ // 1-FP CANDIDATE
					fpQueue.enqueue(fp);
					//System.out.println(fp);
					outputFP.add(fp);
				}
				
			}
			
		}
		outputFP=expandFrequentPatterns(data,minSup,fpQueue,outputFP);
		
	}
	
	 private   LinkList expandFrequentPatterns(Data data, float minSup, 	Queue fpQueue,LinkList outputFP){
		while (!fpQueue.isEmpty()){
			FrequentPattern fp=(FrequentPattern)fpQueue.first(); //fp to be refined
			fpQueue.dequeue();
			for(int i=0;i<data.getNumberOfAttributes();i++){
				boolean found=false;
				for(int j=0;j<fp.getPatternLength();j++) //the new item should involve an attribute different form attributes already involved into the items of fp
					if(fp.getItem(j).getAttribute().equals(data.getAttribute(i))){
						found=true;
						break;
					}
				if(!found) //data.getAttribute(i) is not involve into an item of fp
				{
					for(int j=0;j<((DiscreteAttribute)data.getAttribute(i)).getNumberOfDistinctValues();j++){
						DiscreteItem item=new DiscreteItem(
								(DiscreteAttribute)data.getAttribute(i),
								((DiscreteAttribute)(data.getAttribute(i))).getValue(j)
								);
						FrequentPattern newFP=refineFrequentPattern(fp,item); //generate refinement
						newFP.setSupport(newFP.computeSupport(data));
						if(newFP.getSupport()>=minSup){
							fpQueue.enqueue(newFP);
							//System.out.println(newFP);
							outputFP.add(newFP);
						}
					}
				}
				
					
					
					
			
			
		}
	}
		return outputFP;
	}
	
	

}
	


