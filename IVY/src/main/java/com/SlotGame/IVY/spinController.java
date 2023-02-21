package com.SlotGame.IVY;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class spinController {
	int betAmount=0;
	int [][]myArray= new int [3][3];

	@GetMapping(value = "/")
	public String home() {
		return "welcome to slot game";
	}
	@GetMapping(value = "/getSpin")
	public String spinMethod(@RequestParam Integer incomingBetAmount) {
		this.betAmount=incomingBetAmount;
		int range = 10;
		int randomGeneration1=(int) (Math.random() * range);
		int randomGeneration2=(int) (Math.random() * range);
		int randomGeneration3=(int) (Math.random() * range);
		int randomGeneration4=(int) (Math.random() * range);
		int randomGeneration5=(int) (Math.random() * range);
		int randomGeneration6=(int) (Math.random() * range);
		int randomGeneration7=(int) (Math.random() * range);
		int randomGeneration8=(int) (Math.random() * range);
		int randomGeneration9=(int) (Math.random() * range);
		myArray[0][0]=randomGeneration1;
		myArray[0][1]=randomGeneration2;
		myArray[0][2]=randomGeneration3;
		myArray[1][0]=randomGeneration4;
		myArray[1][1]=randomGeneration5;
		myArray[1][2]=randomGeneration6;
		myArray[2][0]=randomGeneration7;
		myArray[2][1]=randomGeneration8;
		myArray[2][2]=randomGeneration9;
		
		
				
		String myResult =combinations(randomGeneration1,randomGeneration2,randomGeneration3,randomGeneration4,randomGeneration5,
				randomGeneration6,randomGeneration7,randomGeneration8,randomGeneration9);
		
		return "|"+ randomGeneration1+"|"+ randomGeneration2+"|"+randomGeneration3+"|"+  "<br>" +
		"|"+ randomGeneration4+"|"+ randomGeneration5+"|"+randomGeneration6+"|"+ "<br>"+
		 "|"+ randomGeneration7+"|"+ randomGeneration8+"|"+randomGeneration9+"|"+ "<br>" +
		myResult + "<br> Win Combinations: Same numbers available on Vertical, Horizotal and slanting lines";
	}

	public String combinations(int r11, int r12, int r13, int r21, int r22, int r23, int r31, int r32, int r33) {

		String result = "sorry for your loss, you did not win any bet";
		if (r11 == r12 & r12 == r13) {
			betAmount=betAmount*2;
			result="Congratulations you won= "+betAmount;
		}
		if (r21 == r22 & r22 == r23) {
			betAmount=betAmount*3;
			result="Congratulations you won= "+betAmount;
		}
		if (r11 == r12 & r12 == r13) {
			betAmount=betAmount*4;
			result="Congratulations you won= "+betAmount;
		}
		if (r31 == r32 & r32 == r33) {
			betAmount=betAmount*5;
			result="Congratulations you won= "+betAmount;
		}
		if (r11 == r21 & r21 == r31) {
			betAmount=betAmount*21;
			result="Congratulations you won= "+betAmount;
		}
		if (r12 == r22 & r22 == r32) {
			betAmount=betAmount*3;
			result="Congratulations you won= "+betAmount;
		}
		if (r13 == r23 & r23 == r33) {
			betAmount=betAmount*2;
			result="Congratulations you won= "+betAmount;
		}
		if (r11 == r22 & r22 == r33) {
			betAmount=betAmount*4;
			result="Congratulations you won= "+betAmount;
		}
		if (r13 == r22 & r22 == r31) {
			betAmount=betAmount*6;
			result="Congratulations you won= "+betAmount;
		}

		return result;
	}
}
