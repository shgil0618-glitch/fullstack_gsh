package com.thejoa703.controller;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.thejoa703.dto.RecipeLikes3;
import com.thejoa703.dto.Recipes3Dto;
import com.thejoa703.dto.RecipesIngre3;
import com.thejoa703.dto.RecipesStep3;
import com.thejoa703.dto.SearchHistory3;
import com.thejoa703.service.RecipeService;

@Controller
@RequestMapping("/recipe")
public class RecipeController {

    @Autowired
    private RecipeService recipesService;

    // =======================
    // 1. 레시피 목록 / 상세
    // =======================
    @GetMapping("/list")
    public String list(Model model,
                       @RequestParam(value = "page", defaultValue = "1") int page,
                       @RequestParam Map<String, Object> params) {
        int totalCount = recipesService.searchBothCount(params);
        model.addAttribute("paging", totalCount); // 필요 시 페이징 객체로 교체
        model.addAttribute("list", recipesService.searchBothPaging(params));
        return "recipe/list";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam("recipeId") int recipeId,
                         Principal principal,
                         Model model,
                         RedirectAttributes rttr) {
        Recipes3Dto recipe = recipesService.selectRecipe(recipeId);
        if (recipe == null) {
            rttr.addFlashAttribute("result", "레시피를 찾을 수 없습니다.");
            return "redirect:/recipe/list";
        }
        recipesService.incrementRecipeViews(recipeId);
        model.addAttribute("recipe", recipe);

        if (principal != null) {
            int appUserId = getAppUserId(principal);
            boolean liked = recipesService.existsRecipeLike(appUserId, recipeId);
            model.addAttribute("liked", liked);
        }

        return "recipe/detail";
    }

    // =======================
    // 2. 레시피 등록
    // =======================
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/register")
    public String registerForm() {
        return "recipe/register";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/register")
    public String register(Recipes3Dto dto,
                           @RequestParam List<RecipesIngre3> ingredients,
                           @RequestParam List<RecipesStep3> steps,
                           Principal principal,
                           RedirectAttributes rttr) {
        try {
            dto.setAppUserId(getAppUserId(principal));
            int result = recipesService.insertRecipe(dto, ingredients, steps);
            rttr.addFlashAttribute("result", result > 0 ? "레시피 등록 성공" : "레시피 등록 실패");
        } catch (Exception e) {
            e.printStackTrace();
            rttr.addFlashAttribute("result", "서버 오류 발생");
        }
        return "redirect:/recipe/list";
    }

    // =======================
    // 3. 레시피 수정
    // =======================
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/modify")
    public String modifyForm(@RequestParam("recipeId") int recipeId,
                             Principal principal,
                             Model model,
                             RedirectAttributes rttr) {
        Recipes3Dto recipe = recipesService.selectRecipe(recipeId);
        int appUserId = getAppUserId(principal);
        if (recipe == null || recipe.getAppUserId() != appUserId) {
            rttr.addFlashAttribute("result", "수정 권한이 없거나 레시피를 찾을 수 없습니다.");
            return "redirect:/recipe/list";
        }
        model.addAttribute("recipe", recipe);
        return "recipe/modify";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/modify")
    public String modify(Recipes3Dto dto,
                         @RequestParam List<RecipesIngre3> ingredients,
                         @RequestParam List<RecipesStep3> steps,
                         Principal principal,
                         RedirectAttributes rttr) {
        try {
            dto.setAppUserId(getAppUserId(principal));
            int result = recipesService.updateRecipe(dto, ingredients, steps);
            rttr.addFlashAttribute("result", result > 0 ? "레시피 수정 성공" : "레시피 수정 실패");
        } catch (Exception e) {
            e.printStackTrace();
            rttr.addFlashAttribute("result", "서버 오류 발생");
        }
        return "redirect:/recipe/detail?recipeId=" + dto.getRecipeId();
    }

    // =======================
    // 4. 레시피 삭제
    // =======================
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/delete")
    public String delete(@RequestParam("recipeId") int recipeId,
                         Principal principal,
                         RedirectAttributes rttr) {
        try {
            int appUserId = getAppUserId(principal);
            int result = recipesService.deleteRecipe(recipeId);
            rttr.addFlashAttribute("result", result > 0 ? "레시피 삭제 성공" : "삭제 권한이 없습니다.");
        } catch (Exception e) {
            e.printStackTrace();
            rttr.addFlashAttribute("result", "서버 오류 발생");
        }
        return "redirect:/recipe/list";
    }

    // =======================
    // 5. 좋아요
    // =======================
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/like")
    public String like(@RequestParam("recipeId") int recipeId,
                       Principal principal,
                       RedirectAttributes rttr) {
        try {
            int appUserId = getAppUserId(principal);
            if (!recipesService.existsRecipeLike(appUserId, recipeId)) {
                recipesService.insertRecipeLike(new RecipeLikes3(appUserId, recipeId));
            } else {
                recipesService.deleteRecipeLike(appUserId, recipeId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/recipe/detail?recipeId=" + recipeId;
    }

    // =======================
    // 6. 검색 기록
    // =======================
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/search/history")
    public String insertSearchHistory(SearchHistory3 history, Principal principal) {
        history.setAppUserId(getAppUserId(principal));
        recipesService.insertSearchHistory(history);
        return "redirect:/recipe/list";
    }

    // =======================
    // Utility
    // =======================
    private int getAppUserId(Principal principal) {
        return Integer.parseInt(principal.getName()); // 예시: Principal.getName()이 userId 반환
    }
}
