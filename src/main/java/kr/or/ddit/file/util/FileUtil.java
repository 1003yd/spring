package kr.or.ddit.file.util;

public class FileUtil {
	
	/**  
	* Method   : getFileExt 
	* 작성자 : 1003yd 
	* 변경이력 :  
	* @param fileName
	* @return  
	* Method 설명 :  파일 확장자 추출
	*/
	public static String getFileExt(String fileName) {
		//이렇게 사용했을때의 문제점
		// 1. contains를 사용시 .이 확장자 앞에오는 .이 아닌 일반 파일명의 .이 있고 확장자가 없을 경우에도 실행된다.
		// 2. 원래 처음 시도에서는 indexof()를 사용했다 : ()안의 해당 문자열을 포함하는 첫번째 인덱스값을 반환 
		//  => 일시 해결책 : lastIndexOf()를 사용하여 확장자는 맨 마지막에 붙으므로 .의 위치가 가장 마지막에 있는 인덱스를 반환
		//  => 큰 문제점 : 1번 (확장자가 없을때 포함하게 되면 반환하지 말아야 하는데 반환함)
		//  해결책이 뭐가있을까... split??
		if(fileName.contains(".")) {
			String fileNm = fileName.substring(fileName.lastIndexOf("."), fileName.length());
			return fileNm;
		}else {
			return "";
		}
	}
}
