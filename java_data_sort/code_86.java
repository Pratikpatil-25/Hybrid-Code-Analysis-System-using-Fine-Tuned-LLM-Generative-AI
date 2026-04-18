package inversion;
import org.apache.commons.math3.stat.inference.WilcoxonSignedRankTest;
import java.lang.*;

public class SV implements Comparable<SV> {
	public final static boolean test=Main.test;
	public String type;
	public String chr;
	public String chr2;	public int start1;
	public int start2;	public boolean correct;		public int orientation;
	public int homo;
		public SV(Alignment first, Alignment second){
		this.correct=false;
		boolean firstStrand=first.getStrand().equals("+");
		boolean secondStrand=second.getStrand().equals("+");
		if(first.getChr().equals(second.getChr())){
			this.chr=first.getChr();
			this.chr2=second.getChr();
			if((first.getStrand().equals("+") && second.getStrand().equals("+") ) ||
					(first.getStrand().equals("-") && second.getStrand().equals("-") )){
			}else if((first.getStrand().equals("+") && second.getStrand().equals("-") ) ||
					(first.getStrand().equals("-") && second.getStrand().equals("+") )){
								this.type="INV";
				if(Math.abs(first.getRefStart()-second.getRefStart())<100 || Math.abs(first.getRefEnd()-second.getRefEnd())<100){
						this.correct=false;				}
				int tmp=first.getMappingEnd()-second.getMappingStart();
				if(tmp<0){
					this.homo=0;
				}else {
					this.homo=tmp;
				}
																if(firstStrand){
					if(first.getRefEnd()<second.getRefEnd()){
												this.start1=first.getRefEnd()-this.homo;
						this.start2=second.getRefEnd();
						this.orientation=0;
											}else{
						this.start1=first.getRefEnd();
						this.start2=second.getRefEnd()-this.homo;
						this.orientation=1;
											}
				}else if(secondStrand){
					if(first.getRefStart()<second.getRefStart()){
						this.start1=first.getRefStart();
						this.start2=second.getRefStart()+this.homo;
						this.orientation=2;
											}else{
						this.start1=first.getRefStart()+this.homo;
						this.start2=second.getRefStart();
						this.orientation=3;
											}
				}else{
					System.err.println("Program error for firstStrand/secondStrand\n");
					System.exit(1);
				}
				this.correct=true;
			}else{
				System.err.println("correct in orientation."+first.getStrand()+"\t"+ second.getStrand()+"Contact author\n");
				System.exit(1);
			}
		}else{
		}
				if(first.getChr().equals(second.getChr())){
			if(this.getStart1()>this.getStart2()){
				int tmp=this.getStart1();
				this.start1=this.getStart2();
				this.start2=tmp;
			}
		}
	}
	public SV(String string, String chr, int start, int end, int size) {
						this.type=string;
		this.chr=chr;
		this.chr2=chr;
		this.start1=start;
		this.start2=end;
		this.correct=true;	}
	public SV(String string) {
						String[] info=string.split("\t");
		this.type=info[0];
		this.chr=info[1];
		this.chr2=info[2];
		this.start1=Integer.parseInt(info[3]);
		this.start2=Integer.parseInt(info[4]);
			}
	public boolean getSVcorrect(){
		return this.correct;
	}

	@Override
	public int compareTo(SV o) {
				int out=compareChr(this.chr,o.chr);
		if(out==0){
			return this.start1-o.start1;
		}else{
			return out;
		}
	}
	public static int compareChr(String a,String b){	
		return a.compareTo(b);
	}
	public String toString(){
		String info="CHR2="+this.chr2+";END="+this.start2+";HOMO="+this.homo+";orientation="+this.orientation+";";
		String out=this.chr+"\t"+this.start1+" \t"+0+"\tREF\t"+this.type+"\tQUAL\tFILTER\t"+info+"\tGT\tNA\n";
		return out;	
	}
	public String toString(int i) {
				String info="CHR2="+this.chr2+";END="+this.start2+";HOMO="+this.homo+";orientation="+this.orientation+";";
		String out=this.chr+"\t"+this.start1+" \t"+i+"\tREF\t"+this.type+"\tQUAL\tFILTER\t"+info+"\tGT\tNA\n";
		return out;
	}
	public String getType(){
		return this.type;
	}
	public String getchr(){
		return this.chr;
	}
	public String getChr2(){
		return this.chr2;
	}
	public int getStart1(){
		return this.start1;
	}
	public int getStart2(){
		return this.start2;
	}
	public int getOrientation(){
		return this.orientation;
	}
	public int getHomo(){
		return this.homo;
	}
}