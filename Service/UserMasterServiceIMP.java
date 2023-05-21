package com.Project.FormMaster.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.Project.FormMaster.Dto.UserMasterDto;
import com.Project.FormMaster.Entity.UserMaster;


public interface UserMasterServiceIMP {
	
String AddUserData(UserMasterDto userMstDto, MultipartFile multipartFile) throws IOException;

List<Object[]> role();
List<Object[]> gender() ;
List<Object[]> Grid();
Optional<UserMaster> edit(int userMasterId);
}
