package com.exampl.traveler.controller;

import com.exampl.traveler.service.*;
import com.exampl.traveler.vo.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final LoginService loginService;
    private final MyPageService myPageService;
    private final HotelService hotelService;
    private final TicketService ticketService;

    @Autowired
    BoardService boardService;
    //메인페이지 게시판에 5개만 보이게 설정
    @RequestMapping("/")
    public String main(Model model){
        List<BoardVO> board = boardService.getBoard();
        model.addAttribute("board",board);

        return "/main/main";
    }
    @RequestMapping("/nation")
    public String nation(Model model){

        return "/nation/nation";
    }
    @GetMapping("/header")
    public String Header(Model model) {
        return "header";
    }
    @GetMapping("/footer")
    public String Footer(Model model){
        return "foter";
    }

    // admin 페이지
    @GetMapping("admin")
    public String admin(Model model){
        List<MemberVO> vo = loginService.selectAll();
        model.addAttribute("vo",vo);
        return "/admin/admin";
    }

    // 일반회원 마이페이지
    @GetMapping("mypage/{id}")
    public String myPage(@PathVariable("id") String id, Model model){
        MemberVO vo = loginService.selectOne(id);
        model.addAttribute("vo",vo);

        List<UserOrderVO> orders = myPageService.orderSelectID(id);

        for(int i =0; i < orders.size(); i++) {
            if(orders.get(i).getComNO().startsWith("A")){

            }else if(orders.get(i).getComNO().startsWith("h")){
                HotelVO item =  hotelService.getHotelById(orders.get(i).getComNO());
                orders.get(i).setTitle(item.getHotelName());
                orders.get(i).setTime(item.getHotelTime());
            }else if(orders.get(i).getComNO().startsWith("T")){
                TicketVO item = ticketService.getTicketByTickNO(orders.get(i).getComNO());
                orders.get(i).setTitle(item.getTickTitle());
                orders.get(i).setTime(String.valueOf(item.getTickDate()));
            }else if(orders.get(i).getComNO().startsWith("P")){

            }
        }

        model.addAttribute("orders", orders);

        return "/mypage/mypage";
    }

    // 기업회원 관리자
    @GetMapping("binpage/{id}")
    public String binPage(@PathVariable("id") String id, Model model){
        BusinessVO vo = loginService.binSelectOne(id);
        model.addAttribute("vo",vo);

        return "/business/binpage";
    }

}
