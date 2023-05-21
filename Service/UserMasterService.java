package com.Project.FormMaster.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.Project.FormMaster.Dto.UserMasterDto;
import com.Project.FormMaster.Entity.UserMaster;
import com.Project.FormMaster.ImageUpload.FileUploadUtil;
import com.Project.FormMaster.Repository.UserMasterRepository;

@Service
public class UserMasterService implements UserMasterServiceIMP {

	@Autowired
	UserMasterRepository UsRepo;

	public String AddUserData(UserMasterDto userMstDto, MultipartFile multipartFile) throws IOException {
		
		UserMaster UserMst = new UserMaster();

		/*
		 * int count = UsRepo.checkDuplicate(UsRepo.getProductName().toLowerCase(),
		 * String.valueOf(proDto.getProductId()));
		 * 
		 * System.out.println(count);
		 * 
		 * if (count > 0) { return "DATA EXIST";
		 * 
		 * } else {
		 */
		UserMst.setFirstName(userMstDto.getFirstName());
		UserMst.setLastName(userMstDto.getLastName());
	    UserMst.setContactNo(Integer.parseInt(userMstDto.getContactNo()));
		UserMst.setEmail(userMstDto.getEmail());
		UserMst.setGender(userMstDto.getGender());
		UserMst.setRole(userMstDto.getRole());
		UserMst.setUserMasterId(userMstDto.getUserMasterId());
		UserMst.setActive("1");

		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		System.out.println("FILE NAME" + fileName);
		UserMst.setImage(fileName);
		UserMaster savepro = UsRepo.save(UserMst);
		String uploadDir = "src/main/resources/static/pictures/"; //
		System.out.println("path" + uploadDir);

		FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
		System.out.println("FILE" + multipartFile);

		UserMst.setValidFrom(userMstDto.getValidFrom());

		UserMst.setValidTo(userMstDto.getValidTo());

		// product.setDateFrom(Date.valueOf(sdf1.format(sdf.parse(proDto.getDateFrom()))));
		// product.setDateTo(Date.valueOf(sdf1.format(sdf.parse(proDto.getDateTo()))));

		UsRepo.save(UserMst);
		return "DATA SAVED";

	}

	public List<Object[]> role() {
		// TODO Auto-generated method stub
		return UsRepo.role();
	}

	public List<Object[]> gender() {
		// TODO Auto-generated method stub
		return UsRepo.gender();
	}

	public List<Object[]> Grid() {
		List<Object[]> l = UsRepo.Grid();
		{

			l.forEach(e -> {
			});

			return l;
		}
	}

	public Optional<UserMaster> edit(int userMasterId) {
		// TODO Auto-generated method stub
		return UsRepo.findById(userMasterId);
	}

	public void UserDel(int userMasterId) {
		UserMaster user = new UserMaster();
		Optional<UserMaster> userid = UsRepo.findById(userMasterId);
		System.out.println("id " + userMasterId);
		user = userid.get();
		System.out.println("usser"+user);
		user.setActive("9");
		UsRepo.save(user);
		
	}

	public UserMaster findByEmail(String email) {
		// TODO Auto-generated method stub
		return UsRepo.findByEmail(email) ;
	
	}

}
