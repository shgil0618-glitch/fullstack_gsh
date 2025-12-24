package com.thejoa703.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thejoa703.dto.AppUserDto;
import com.thejoa703.dto.PagingDto;
import com.thejoa703.dto.Recipes3Dto;
import com.thejoa703.dto.RecipesIngre3;
import com.thejoa703.dto.RecipesStep3;
import com.thejoa703.security.CustomUserDetails;
import com.thejoa703.service.RecipeService;
import com.thejoa703.service.AppUserService;

@Controller
@RequestMapping("/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private AppUserService userService;

    // 📌 레시피 상세 조회
    @GetMapping("/detail")
    public String detail(@RequestParam("recipeId") int recipeId,
                         Authentication authentication,
                         Model model,
                         RedirectAttributes rttr) {
        Recipes3Dto recipe = recipeService.getRecipeById(recipeId);
        if (recipe == null) {
            rttr.addFlashAttribute("result", "레시피를 찾을 수 없습니다.");
            return "redirect:/recipes/list";
        }

        // ✅ 조회수 증가
        recipeService.incrementViews(recipeId);

        model.addAttribute("recipe", recipe);
        model.addAttribute("ingredients", recipeService.getIngredients(recipeId));
        model.addAttribute("steps", recipeService.getSteps(recipeId));

        // 로그인 사용자 정보 추가
        if (authentication != null) {
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
            if (user != null) {
                model.addAttribute("loginUser", user);
            }
        }

        return "/recipe/detail";
    }
    
    // 📌 레시피 등록 폼
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/register")
    public String registerForm() {
        return "/recipe/register";
    }

 // 📌 레시피 등록 처리 (레시피 + 재료 + 단계)
    @PostMapping("/register")
    @PreAuthorize("isAuthenticated()")
    public String register(Recipes3Dto dto,
                           @RequestParam(value = "imageFile", required = false) MultipartFile imageFile,
                           @RequestParam(value = "ingredients", required = false) List<String> ingreNames,
                           @RequestParam(value = "ingreNums", required = false) List<String> ingreNums,
                           @RequestParam(value = "steps", required = false) List<String> stepDescs,
                           @RequestParam(value = "stepImages", required = false) List<MultipartFile> stepImages,
                           Authentication authentication,
                           RedirectAttributes rttr) {

        AppUserDto user = getLoginUser(authentication);
        if (user == null) {
            rttr.addFlashAttribute("result", "로그인 후 이용 가능합니다.");
            return "redirect:/login";
        }

        dto.setAppUserId(user.getAppUserId());

        // 재료 세팅
        List<RecipesIngre3> ingreList = new ArrayList<>();
        if (ingreNames != null) {
            for (int i = 0; i < ingreNames.size(); i++) {
                RecipesIngre3 ingre = new RecipesIngre3();
                ingre.setIngreName(ingreNames.get(i));
                ingre.setIngreNum(
                    ingreNums != null && ingreNums.size() > i ? ingreNums.get(i) : null
                );
                ingreList.add(ingre);
            }
        }
        dto.setIngredients(ingreList);

        // 단계 세팅
        List<RecipesStep3> stepList = new ArrayList<>();
        if (stepDescs != null) {
            for (int i = 0; i < stepDescs.size(); i++) {
                RecipesStep3 step = new RecipesStep3();
                step.setStepDesc(stepDescs.get(i));
                stepList.add(step);
            }
        }
        dto.setSteps(stepList);

        recipeService.createRecipe(imageFile, dto, stepImages);

        rttr.addFlashAttribute("result", "레시피 등록 성공");
        return "redirect:/recipes/list";
    }


    // 📌 레시피 수정 폼
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/modify")
    public String modifyForm(@RequestParam("recipeId") int recipeId,
                             Model model,
                             RedirectAttributes rttr) {
        Recipes3Dto recipe = recipeService.getRecipeById(recipeId);
        if (recipe == null) {
            rttr.addFlashAttribute("result", "레시피를 찾을 수 없습니다.");
            return "redirect:/recipes/list";
        }

        model.addAttribute("recipe", recipe);
        model.addAttribute("ingredients", recipeService.getIngredients(recipeId));
        model.addAttribute("steps", recipeService.getSteps(recipeId));

        return "/recipe/modify";
    }

    // 📌 레시피 수정 처리 (레시피 + 재료 + 단계)
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/modify")
    public String modify(Recipes3Dto dto,
                         @RequestParam(value = "imageFile", required = false) MultipartFile imageFile,
                         @RequestParam(value = "ingredients", required = false) List<String> ingreNames,
                         @RequestParam(value = "ingreNums", required = false) List<String> ingreNums,
                         @RequestParam(value = "steps", required = false) List<String> stepDescs,
                         @RequestParam(value = "stepImages", required = false) List<MultipartFile> stepImages,
                         Authentication authentication,
                         RedirectAttributes rttr) {

        String resultMessage = "레시피 수정 실패";

        try {
            // ✅ 로그인 사용자 정보(email + provider)
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
            if (user == null) {
                rttr.addFlashAttribute("result", "사용자 정보를 찾을 수 없습니다.");
                return "redirect:/recipes/list";
            }

            dto.setAppUserId(user.getAppUserId());

            // ✅ 재료 리스트 DTO에 세팅
            List<RecipesIngre3> ingreList = new ArrayList<>();
            if (ingreNames != null) {
                for (int i = 0; i < ingreNames.size(); i++) {
                    RecipesIngre3 ingre = new RecipesIngre3();
                    ingre.setRecipeId(dto.getRecipeId());
                    ingre.setIngreName(ingreNames.get(i));
                    ingre.setIngreNum(ingreNums != null && ingreNums.size() > i ? ingreNums.get(i) : null);
                    ingreList.add(ingre);
                }
            }
            dto.setIngredients(ingreList);

            // ✅ 단계 리스트 DTO에 세팅
            List<RecipesStep3> stepList = new ArrayList<>();
            if (stepDescs != null) {
                for (int i = 0; i < stepDescs.size(); i++) {
                    RecipesStep3 step = new RecipesStep3();
                    step.setRecipeId(dto.getRecipeId());
                    step.setStepDesc(stepDescs.get(i));
                    stepList.add(step);
                }
            }
            dto.setSteps(stepList);

            // ✅ Service에서 updateRecipe 호출 → DB 반영
            int result = recipeService.updateRecipe(imageFile, dto, stepImages);

            if (result > 0) {
                resultMessage = "레시피 수정 성공";
            }

        } catch (Exception e) {
            // 로깅 프레임워크 사용 권장
            e.printStackTrace();
            resultMessage = "레시피 수정 중 오류 발생";
        }

        rttr.addFlashAttribute("result", resultMessage);
        return "redirect:/recipes/detail?recipeId=" + dto.getRecipeId();
    }
    
    
    // 📌 레시피 목록 (페이징)
    @GetMapping("/list")
    public String list(@RequestParam(value = "page", defaultValue = "1") int currentPage,
                       @RequestParam(value = "category", required = false) Integer category,
                       Model model) {

        // 전체 레시피 개수
        int totalCount = recipeService.countAll(category);

        // PagingDto 생성
        PagingDto paging = new PagingDto(totalCount, currentPage);
        model.addAttribute("paging", paging);

        // 페이징된 레시피 목록 조회
        var params = new java.util.HashMap<String, Object>();
        params.put("rStart", paging.getRStart());
        params.put("rEnd", paging.getREnd());
        params.put("category", category);

        List<Recipes3Dto> recipeList = recipeService.selectRecipeAllPaged(params);
        model.addAttribute("list", recipeList);

        return "/recipe/list";
    }
    

    // 📌 레시피 검색 (페이징 + 정렬)
    @GetMapping("/search")
    public String search(@RequestParam(value = "page", defaultValue = "1") int currentPage,
                         @RequestParam(value = "keyword", required = false) String keyword,
                         @RequestParam(value = "searchField", defaultValue = "ALL") String searchField,
                         @RequestParam(value = "sort", defaultValue = "LATEST") String sort,
                         @RequestParam(value = "category", required = false) Integer category,
                         Model model) {

        // 검색 결과 개수
        var countParams = new java.util.HashMap<String, Object>();
        countParams.put("keyword", keyword);
        countParams.put("searchField", searchField);
        countParams.put("category", category);

        int totalCount = recipeService.countSearchRecipes(countParams);

        // PagingDto 생성
        PagingDto paging = new PagingDto(totalCount, currentPage);
        model.addAttribute("paging", paging);

        // 검색 결과 목록 조회
        var params = new java.util.HashMap<String, Object>();
        params.put("keyword", keyword);
        params.put("searchField", searchField);
        params.put("sort", sort);
        params.put("category", category);
        params.put("rStart", paging.getRStart());
        params.put("rEnd", paging.getREnd());

        List<Recipes3Dto> recipeList = recipeService.searchRecipesPaged(params);
        model.addAttribute("list", recipeList);

        // 검색 조건 유지
        model.addAttribute("keyword", keyword);
        model.addAttribute("searchField", searchField);
        model.addAttribute("sort", sort);
        model.addAttribute("category", category);

        return "/recipe/search";
    }
    
 // 📌 레시피 검색 (AJAX JSON 응답)
    @GetMapping("/searchAjax")
    @ResponseBody
    public Map<String, Object> searchAjax(@RequestParam(value = "page", defaultValue = "1") int currentPage,
                                          @RequestParam(value = "keyword", required = false) String keyword,
                                          @RequestParam(value = "searchField", defaultValue = "ALL") String searchField,
                                          @RequestParam(value = "sort", defaultValue = "LATEST") String sort,
                                          @RequestParam(value = "category", required = false) Integer category) {

        Map<String, Object> result = new HashMap<>();

        // 검색 결과 개수
        var countParams = new HashMap<String, Object>();
        countParams.put("keyword", keyword);
        countParams.put("searchField", searchField);
        countParams.put("category", category);

        int totalCount = recipeService.countSearchRecipes(countParams);

        // PagingDto 생성
        PagingDto paging = new PagingDto(totalCount, currentPage);

        // 검색 결과 목록 조회
        var params = new HashMap<String, Object>();
        params.put("keyword", keyword);
        params.put("searchField", searchField);
        params.put("sort", sort);
        params.put("category", category);
        params.put("rStart", paging.getRStart());
        params.put("rEnd", paging.getREnd());

        List<Recipes3Dto> recipeList = recipeService.searchRecipesPaged(params);

        // JSON 응답 구성
        result.put("list", recipeList);
        result.put("paging", paging);

        return result;
    }
    
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/mylist")
    public String myList(Authentication authentication, Model model, RedirectAttributes rttr) {
        if (authentication == null) {
            rttr.addFlashAttribute("result", "로그인 후 이용 가능합니다.");
            return "redirect:/login";
        }

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
        if (user == null) {
            rttr.addFlashAttribute("result", "사용자 정보를 찾을 수 없습니다.");
            return "redirect:/recipes/list";
        }

        List<Recipes3Dto> myList = recipeService.selectMyRecipes(user.getAppUserId());
        model.addAttribute("list", myList);

        return "/recipe/mylist";
    }
    
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/likes")
    public String likedRecipes(Authentication authentication, Model model, RedirectAttributes rttr) {
        if (authentication == null) {
            rttr.addFlashAttribute("result", "로그인 후 이용 가능합니다.");
            return "redirect:/login";
        }

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
        if (user == null) {
            rttr.addFlashAttribute("result", "사용자 정보를 찾을 수 없습니다.");
            return "redirect:/recipes/list";
        }

        List<Recipes3Dto> likedList = recipeService.selectLikedRecipes(user.getAppUserId());
        model.addAttribute("list", likedList);

        return "/recipe/likes";
    }
    
    // 📌 좋아요 추가
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/like")
    @ResponseBody
    public Map<String, Object> likeRecipe(@RequestParam("recipeId") int recipeId,
                                          Authentication authentication) {
        Map<String, Object> result = new HashMap<>();
        try {
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
            recipeService.likeRecipe(user.getAppUserId(), recipeId);

            result.put("success", true);
            result.put("likes", recipeService.countLikesByRecipe(recipeId));
        } catch (Exception e) {
            result.put("success", false);
            result.put("error", e.getMessage());
        }
        return result;
    }

    // 📌 좋아요 취소
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/unlike")
    @ResponseBody
    public Map<String, Object> unlikeRecipe(@RequestParam("recipeId") int recipeId,
                                            Authentication authentication) {
        Map<String, Object> result = new HashMap<>();
        try {
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
            recipeService.unlikeRecipe(user.getAppUserId(), recipeId);

            result.put("success", true);
            result.put("likes", recipeService.countLikesByRecipe(recipeId));
        } catch (Exception e) {
            result.put("success", false);
            result.put("error", e.getMessage());
        }
        return result;
    }

    // 📌 좋아요 개수 조회
    @GetMapping("/likes/count")
    @ResponseBody
    public Map<String, Object> countLikes(@RequestParam("recipeId") int recipeId) {
        Map<String, Object> result = new HashMap<>();
        result.put("likes", recipeService.countLikesByRecipe(recipeId));
        return result;
    }
    
    private AppUserDto getLoginUser(Authentication authentication) {
        if (authentication == null) return null;

        String email = null;
        String provider = null;
        Object principal = authentication.getPrincipal();

        if (principal instanceof CustomUserDetails) {
            CustomUserDetails userDetails = (CustomUserDetails) principal;
            email = userDetails.getUser().getEmail();
            provider = userDetails.getUser().getProvider();
        } 
        else if (principal instanceof OAuth2User) {
            OAuth2User oAuth2User = (OAuth2User) principal;
            email = (String) oAuth2User.getAttributes().get("email");
            if (authentication instanceof OAuth2AuthenticationToken) {
                provider = ((OAuth2AuthenticationToken) authentication)
                                .getAuthorizedClientRegistrationId();
            }
        }

        return userService.selectEmail(email, provider);
    }

    
}
    