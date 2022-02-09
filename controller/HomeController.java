package com.sparta.selectshop2.controller;

import com.sparta.selectshop2.model.Folder;
import com.sparta.selectshop2.model.UserRoleEnum;
import com.sparta.selectshop2.repository.FolderRepository;
import com.sparta.selectshop2.security.UserDetailsImpl;
import com.sparta.selectshop2.service.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final FolderService folderService;

    @Autowired
    public HomeController(FolderService folderService){
        this.folderService = folderService;
    }

    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        model.addAttribute("username", userDetails.getUsername());

        if (userDetails.getUser().getRole() == UserRoleEnum.ADMIN) {
            model.addAttribute("admin_role", true);
        }

        // 폴더 등록하기
        List<Folder> folderList = folderService.getFolders(userDetails.getUser());
        model.addAttribute("folders", folderList);

        return "index";
    }
}