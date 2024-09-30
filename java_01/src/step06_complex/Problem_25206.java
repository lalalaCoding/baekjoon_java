import java.io.*;

public class Problem_25206{
	public static void main(String[] args){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		double sum = 0.0D;
		double hakSum = 0.0D;
		double avg;
		
		try{
			for(int i = 0; i < 20; i++){
				
				String[] info = br.readLine().split(" ");
				double hak = Double.parseDouble(info[1]);
				
				switch(info[2]){
				case "A+" : sum += hak*4.5D; hakSum += hak; break;
				case "A0" : sum += hak*4.0D; hakSum += hak; break;
				case "B+" : sum += hak*3.5D; hakSum += hak; break;
				case "B0" : sum += hak*3.0D; hakSum += hak; break;
				case "C+" : sum += hak*2.5D; hakSum += hak; break;
				case "C0" : sum += hak*2.0D; hakSum += hak; break;
				case "D+" : sum += hak*1.5D; hakSum += hak; break;
				case "D0" : sum += hak*1.0D; hakSum += hak; break;
				case "F" : sum += 0.0D; hakSum += hak; break;
				}
				
			}
			avg = sum/hakSum;
			bw.write(avg+"");
			bw.flush();
			bw.close();
			br.close();
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
	
	}
}