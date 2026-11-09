/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;

import java.util.ArrayList;
import java.util.List;
import model.Candidate;

/**
 *
 * @author nguye
 */
public class CandidateManager {
    private final List<Candidate> candidates = new ArrayList<>();
    public boolean isIdExist(String id){
        for(Candidate c : candidates){
            if(c.getId().equalsIgnoreCase(id)){
                return true;
            }
        }
        return false;
        
    }
    public void addCandidate(Candidate c){
        if(isIdExist(c.getId())){
            throw new IllegalArgumentException("Id is exist !");
        }
        candidates.add(c);
    }
    public List<Candidate> getAll(){
        return candidates;
    }
    // Lay cac ung vien theo loai (0, 1, 2)
    public List<Candidate> getByType(int type){
        List<Candidate> result = new ArrayList<>();
        for(Candidate c : candidates){
            if(c.getType() == type ){
                result.add(c);
            }
        }
        return result;
    }
    
    // tim theo ten (First hoac Last name, chua , khong phan biet hoa thuong ) va dung loai 
    public List<Candidate> search(String name,int type){
        String key = name.toLowerCase();
        List<Candidate> rs = new ArrayList<>();
        for(Candidate c : getByType(type)){
            if(c.getFullName().toLowerCase().contains(key)){
                rs.add(c);
            }
        }
        return rs;
    }

}
