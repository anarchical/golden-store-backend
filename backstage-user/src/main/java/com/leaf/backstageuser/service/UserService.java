package com.leaf.backstageuser.service;

import com.leaf.backstageuser.repository.AddressRepository;
import com.leaf.backstageuser.repository.UserRepository;
import com.leaf.backstageuser.vo.AddressVO;
import com.leaf.backstageuser.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author YeYaqiao
 * @email yyq920201895@163.com
 * @time 2020/5/5 8:35 下午
 */
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    AddressRepository addressRepository;

    public Page<UserVO> getAllUser(Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);

        Page<UserVO> userVOPage = userRepository.findAllUserVO(pageRequest);

        for (UserVO userVO : userVOPage) {
            List<AddressVO> addressVOList = addressRepository.findAddressByUserId(userVO.getId());
            userVO.setAddressVOList(addressVOList);
        }
        return userVOPage;
    }

    public UserVO getUserVOById(int id) {
        UserVO userVO = userRepository.findUserVOById(id);
        userVO.setAddressVOList(addressRepository.findAddressByUserId(id));
        return userVO;
    }

    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }


}
