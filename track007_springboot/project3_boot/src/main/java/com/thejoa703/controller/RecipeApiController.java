package com.thejoa703.controller;
/*
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import com.thejoa703.dto.Recipes3Dto;
import com.thejoa703.dto.RecipesStep3;
import com.thejoa703.security.CustomUserDetails;
import com.thejoa703.service.RecipeService;
import com.thejoa703.service.AppUserService;

@RestController
@RequestMapping("/api/recipes")
public class RecipeApiController {

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private AppUserService userService;

    // ✅ 1. 검색어 → 자연어 API 호출
    @GetMapping("/search")
    public Map<String, Object> searchRecipes(@RequestParam("keyword") String keyword,
                                             @RequestParam(value = "searchField", defaultValue = "ALL") String searchField,
                                             @RequestParam(value = "sort", defaultValue = "LATEST") String sort,
                                             @RequestParam(value = "category", required = false) Integer category,
                                             @RequestParam(value = "page", defaultValue = "1") int currentPage) {
        Map<String, Object> result = new HashMap<>();

        var params = new HashMap<String, Object>();
        params.put("keyword", keyword);
        params.put("searchField", searchField);
        params.put("sort", sort);
        params.put("category", category);

        int totalCount = recipeService.countSearchRecipes(params);
        if (totalCount == 0) {
            // 👉 기존 DB에서 결과가 없으면 외부 자연어 검색 API 호출
            result.put("source", "AI_API");
            result.put("data", recipeService.callAiSearchApi(keyword));
        } else {
            result.put("source", "DB");
            result.put("data", recipeService.searchRecipesPaged(params));
        }
        return result;
    }

    // ✅ 2. 레시피 작성 Step 설명 자동완성 API
    @PostMapping("/steps/complete")
    public Map<String, Object> completeStep(@RequestBody RecipesStep3 step) {
        Map<String, Object> result = new HashMap<>();
        if (step.getStepDesc() == null || step.getStepDesc().length() < 20) {
            // 👉 설명이 짧으면 AI API로 자동완성
            String completed = recipeService.callAiStepApi(step.getStepDesc());
            step.setStepDesc(completed);
            result.put("completedStep", step);
        } else {
            result.put("completedStep", step);
        }
        return result;
    }

    // ✅ 3. 비속어 검증 API
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/validate")
    public Map<String, Object> validateRecipe(@RequestBody Recipes3Dto dto,
                                              Authentication authentication) {
        Map<String, Object> result = new HashMap<>();

        String email = null, provider = null;
        Object principal = authentication.getPrincipal();
        if (principal instanceof CustomUserDetails) {
            CustomUserDetails userDetails = (CustomUserDetails) principal;
            email = userDetails.getUser().getEmail();
            provider = userDetails.getUser().getProvider();
        } else if (principal instanceof OAuth2User) {
            OAuth2User oAuth2User = (OAuth2User) principal;
            email = (String) oAuth2User.getAttributes().get("email");
            if (authentication instanceof OAuth2AuthenticationToken) {
                provider = ((OAuth2AuthenticationToken) authentication).getAuthorizedClientRegistrationId();
            }
        }

        var user = userService.selectEmail(email, provider);
        dto.setAppUserId(user.getAppUserId());

        // 👉 비속어 테이블 검증
        boolean containsBadWords = recipeService.containsBadWords(dto);
        if (containsBadWords) {
            dto.setStatus("DRAFT");
            result.put("status", "DRAFT");
            result.put("reason", "비속어 검출됨");
        } else {
            // 👉 외부 비속어 API 호출
            boolean aiBadWord = recipeService.callAiBadWordApi(dto);
            if (aiBadWord) {
                dto.setStatus("DRAFT");
                result.put("status", "DRAFT");
                result.put("reason", "AI 비속어 검출됨");
            } else {
                dto.setStatus("PUBLIC");
                result.put("status", "PUBLIC");
                result.put("reason", "검증 통과");
            }
        }

        result.put("recipe", dto);
        return result;
    }
}
*/