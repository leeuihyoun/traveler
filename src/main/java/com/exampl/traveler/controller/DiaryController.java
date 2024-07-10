package com.exampl.traveler.controller;

import com.exampl.traveler.service.DiaryService;
import com.exampl.traveler.vo.DiaryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/diary")
public class DiaryController {

    @Autowired
    private DiaryService diaryService;

    @GetMapping("/{userId}")
    public String getDiary(@PathVariable("userId") String userId, Model model) {
        model.addAttribute("userId", userId);
        return "schedule/diary";  // This will render diary.html
    }

    @GetMapping("/entries/{userId}")
    @ResponseBody
    public List<DiaryVO> getDiaryEntries(@PathVariable("userId") String userId) {
        return diaryService.show(userId);
    }

    @PostMapping
    @ResponseBody
    public String saveDiaryEntry(@RequestBody DiaryVO diaryVO) {
        diaryService.save(diaryVO);
        return "일정이 저장되었습니다.";
    }
}