package com.exampl.traveler.service;

import com.exampl.traveler.mapper.NationMapper;
import com.exampl.traveler.vo.NationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NationService {
    private final NationMapper nationMapper;

    @Autowired
    public NationService(NationMapper nationMapper) {
        this.nationMapper = nationMapper;
    }

    public List<NationVO> getAllNation() {
        return nationMapper.getAllNation();
    }

    public NationVO getNationById(String natNO) {
        return nationMapper.getNationById(natNO);
    }
}
