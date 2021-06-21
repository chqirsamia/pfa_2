package com.inventaire.service;

import com.inventaire.dao.SequenceDAO;
import com.inventaire.model.Sequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SequenceService {
    @Autowired
    SequenceDAO sequenceDAO;

    public void addSequence(Sequence s){
        sequenceDAO.save(s);
    }

    public int findPlusGrand(){
        int max =0;
        List<Sequence> s = sequenceDAO.findAll();
        for(int i=0;i<s.size();i++){
            if(max<s.get(i).getId_sequence()) max=s.get(i).getId_sequence();
        }
        return max;
    }
}
