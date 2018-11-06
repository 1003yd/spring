package kr.or.ddit.file.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.file.dao.FileDaoInf;
import kr.or.ddit.file.model.FileVo;


@Service("fileService")
public class FileService implements FileServiceInf{
	
	//객체를 주입을 받을떄 사용하는 annotation 이다
	@Resource(name="fileDao")
	private FileDaoInf fileDao;
	
	
	@Override
	public int insertFile(FileVo fileVo) {
		// TODO Auto-generated method stub
		return fileDao.insertFile(fileVo);
	}
	

}
