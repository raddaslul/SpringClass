package com.sparta.selectshop2.service;

import com.sparta.selectshop2.model.Folder;
import com.sparta.selectshop2.model.Product;
import com.sparta.selectshop2.model.User;
import com.sparta.selectshop2.repository.FolderRepository;
import com.sparta.selectshop2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FolderService {

    private final FolderRepository folderRepository;
    private final ProductRepository productRepository;

    @Autowired
    public FolderService(
            FolderRepository folderRepository,
            ProductRepository productRepository
    ) {
        this.folderRepository= folderRepository;
        this.productRepository= productRepository;
    }

    // 로그인한 회원에 폴더를 등록
    public List<Folder> addFolders(List<String> folderNames, User user) {

        List<Folder> existFolderList = folderRepository.findAllByUserAndNameIn(user, folderNames);
        List<Folder> folderList = new ArrayList<>();

        for (String folderName : folderNames) {
            if (!isExistFolderName(folderName, existFolderList)) {
                Folder folder = new Folder(folderName, user);
                folderList.add(folder);
            }
        }
        return folderRepository.saveAll(folderList); // 객체를 또 생성하지 말고, 위에 생성된 배열 객체에 덮어쓰기
    }

    // 로그인한 회원이 등록된 모든 폴더 조회
    public List<Folder> getFolders(User user) {
       return folderRepository.findAllByUser(user);
    }

    // 회원 ID가 소유한 폴더에 저장되어 있는 상품들 조회
    public Page<Product> getProductsInFolder(
            Long folderId,
            int page,
            int size,
            String sortBy,
            boolean isAsc,
            User user
    ) {
        Long userId = user.getId();
        Sort.Direction direction = isAsc ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sort = Sort.by(direction, sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        return productRepository.findAllByUserIdAndFolderList_Id(userId, folderId, pageable);
    }

    private boolean isExistFolderName(String folderName, List<Folder> existFolderList) {
        for (Folder existfolder : existFolderList) {
            String existName = existfolder.getName();
            if(folderName.equals(existName)) {
                return false;
            }
        }
        return true;
    }
}
