package com.thejoa703.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thejoa703.dto.PagingDto;
import com.thejoa703.dto.Recipes3Dto;
import com.thejoa703.dto.RecipesIngre3;
import com.thejoa703.dto.RecipesStep3;
import com.thejoa703.service.RecipeService;

@Controller
@RequestMapping("/recipes")
public class RecipeController {

    private final RecipeService recipesService;

    // application.properties에 설정된 업로드 루트 경로 주입 (예: C:/upload)
    @Value("${resource.path}")
    private String resourcePath;

    public RecipeController(RecipeService recipesService) {
        this.recipesService = recipesService;
    }

    /* 레시피 작성 폼 */
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("dto", new Recipes3Dto());
        model.addAttribute("categories", recipesService.getAllCategories());
        return "recipes/new";
    }

    /* 레시피 등록 (이미지 파일은 service에서 저장) */
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/new")
    public String createRecipe(@RequestParam(value = "imageFile", required = false) MultipartFile imageFile,
                               Recipes3Dto dto,
                               RedirectAttributes rttr) {
        int result = recipesService.createRecipe(imageFile, dto);
        rttr.addFlashAttribute("msg", result > 0 ? "레시피 등록 성공" : "레시피 등록 실패");
        return "redirect:/recipes/list";
    }

    /* 레시피 수정 폼 */
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/edit")
    public String editForm(@RequestParam int recipeId, Model model) {
        Recipes3Dto dto = recipesService.getRecipeById(recipeId);
        model.addAttribute("dto", dto);
        model.addAttribute("ingredients", recipesService.getIngredients(recipeId));
        model.addAttribute("steps", recipesService.getSteps(recipeId));
        model.addAttribute("categories", recipesService.getAllCategories());
        return "recipes/edit";
    }

    /* 레시피 수정 처리 (이미지 파일은 service에서 저장/교체) */
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/edit")
    public String updateRecipe(@RequestParam(value = "imageFile", required = false) MultipartFile imageFile,
                               Recipes3Dto dto,
                               RedirectAttributes rttr) {
        int result = recipesService.updateRecipe(imageFile, dto);
        rttr.addFlashAttribute("msg", result > 0 ? "레시피 수정 성공" : "레시피 수정 실패");
        return "redirect:/recipes/view?recipeId=" + dto.getRecipeId();
    }

    /* 삭제 폼 */
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/delete")
    public String deleteForm(@RequestParam int recipeId, Model model) {
        Recipes3Dto dto = recipesService.getRecipeById(recipeId);
        model.addAttribute("dto", dto);
        return "recipes/delete";
    }

    /* 삭제 처리 */
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/delete")
    public String deleteRecipe(@RequestParam int recipeId, RedirectAttributes rttr) {
        int result = recipesService.deleteRecipe(recipeId);
        rttr.addFlashAttribute("msg", result > 0 ? "삭제 성공" : "삭제 실패");
        return "redirect:/recipes/list";
    }

    /* 상세 조회 */
    @GetMapping("/view")
    public String viewRecipe(@RequestParam int recipeId,
                             @RequestParam(defaultValue = "true") boolean incView,
                             Model model) {
        if (incView) recipesService.incrementViews(recipeId);
        Recipes3Dto dto = recipesService.getRecipeById(recipeId);
        model.addAttribute("dto", dto);
        model.addAttribute("ingredients", recipesService.getIngredients(recipeId));
        model.addAttribute("steps", recipesService.getSteps(recipeId));
        model.addAttribute("likeCount", recipesService.countLikesByRecipe(recipeId));
        return "recipes/view";
    }


    /* ---------------------------
       전체 목록 (최신순) 페이징
       GET /recipes/list?page=1&size=8
       --------------------------- */
    @GetMapping("/list")
    public String listRecipes(@RequestParam(defaultValue = "1") int page,
                              @RequestParam(defaultValue = "8") int size,
                              @RequestParam(required = false) Integer category,
                              Model model) {
        int total = recipesService.countAll(category);
        PagingDto paging = new PagingDto(total, page);
        Map<String, Object> params = new HashMap<>();
        params.put("rStart", paging.getRStart());
        params.put("rEnd", paging.getREnd());
        params.put("category", category);

        List<Recipes3Dto> list = recipesService.selectRecipeAllPaged(params);
        model.addAttribute("list", list);
        model.addAttribute("paging", paging);
        model.addAttribute("categories", recipesService.getAllCategories());
        return "recipes/list";
    }

    /* ---------------------------
       검색 + 정렬 + 페이징
       GET /recipes/search?keyword=...&sort=LATEST&page=1
       --------------------------- */
    @GetMapping("/search")
    public String searchRecipes(@RequestParam(required = false) String keyword,
                                @RequestParam(defaultValue = "ALL") String searchField,
                                @RequestParam(required = false) Integer category,
                                @RequestParam(defaultValue = "LATEST") String sort,
                                @RequestParam(defaultValue = "1") int page,
                                @RequestParam(defaultValue = "8") int size,
                                Model model) {

        Map<String, Object> countParams = new HashMap<>();
        countParams.put("keyword", keyword);
        countParams.put("searchField", searchField);
        countParams.put("category", category);
        int total = recipesService.countSearchRecipes(countParams);

        PagingDto paging = new PagingDto(total, page);
        Map<String, Object> params = new HashMap<>();
        params.put("keyword", keyword);
        params.put("searchField", searchField);
        params.put("category", category);
        params.put("sort", sort);
        params.put("rStart", paging.getRStart());
        params.put("rEnd", paging.getREnd());

        List<Recipes3Dto> list = recipesService.searchRecipesPaged(params);
        recipesService.saveSearchHistory(null, keyword);
        model.addAttribute("list", list);
        model.addAttribute("paging", paging);
        model.addAttribute("keyword", keyword);
        model.addAttribute("categories", recipesService.getAllCategories());
        return "recipes/search";
    }

    /* ---------------------------
       좋아요 / 좋아요 취소
       POST /recipes/like
       POST /recipes/unlike
       --------------------------- */
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/like")
    public String likeRecipe(@RequestParam int recipeId,
                             @RequestParam int appUserId) {
        recipesService.likeRecipe(appUserId, recipeId);
        return "redirect:/recipes/view?recipeId=" + recipeId;
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/unlike")
    public String unlikeRecipe(@RequestParam int recipeId,
                               @RequestParam int appUserId) {
        recipesService.unlikeRecipe(appUserId, recipeId);
        return "redirect:/recipes/view?recipeId=" + recipeId;
    }

    /* ---------------------------
       재료 / 단계 조회
       GET /recipes/ingredients?recipeId=...
       GET /recipes/steps?recipeId=...
       --------------------------- */
    @GetMapping("/ingredients")
    public String ingredientsFragment(@RequestParam int recipeId, Model model) {
        model.addAttribute("ingredients", recipesService.getIngredients(recipeId));
        return "recipes/fragments :: ingredients";
    }

    @GetMapping("/steps")
    public String stepsFragment(@RequestParam int recipeId, Model model) {
        model.addAttribute("steps", recipesService.getSteps(recipeId));
        return "recipes/fragments :: steps";
    }

    /* ---------------------------
    관리자 기능 (동일 컨트롤러에 포함)
    --------------------------- */
 @PreAuthorize("hasRole('ADMIN')")
 @GetMapping("/admin/badwords")
 public String adminBadWords(Model model) {
     model.addAttribute("badWords", recipesService.getAllBadWords());
     return "admin/badwords";
 }

 @PreAuthorize("hasRole('ADMIN')")
 @PostMapping("/admin/bad_add")
 public String addBadWord(@RequestParam String word, RedirectAttributes rttr) {
     recipesService.addBadWord(word);
     rttr.addFlashAttribute("msg", "비속어 추가 완료");
     return "redirect:/recipes/admin/badwords";
 }

 @PreAuthorize("hasRole('ADMIN')")
 @PostMapping("/admin/bad_delete")
 public String deleteBadWord(@RequestParam int wordId, RedirectAttributes rttr) {
     recipesService.deleteBadWordById(wordId);
     rttr.addFlashAttribute("msg", "비속어 삭제 완료");
     return "redirect:/recipes/admin/badwords";
 }

 @PreAuthorize("hasRole('ADMIN')")
 @GetMapping("/admin/ai_usage")
 public String adminAiUsage(Model model) {
     model.addAttribute("aiUsage", recipesService.getAllAiUsage());
     return "admin/aiusage";
 }

 @PreAuthorize("hasRole('ADMIN')")
 @PostMapping("/admin/ai_delete")
 public String deleteAiUsage(@RequestParam int aiHistId, RedirectAttributes rttr) {
     recipesService.deleteAiUsageById(aiHistId);
     rttr.addFlashAttribute("msg", "AI 사용 기록 삭제 완료");
     return "redirect:/recipes/admin/ai_usage";
 }
}
