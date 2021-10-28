package com.example.springmvcbasic2.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository //스프링 빈에 등록됨.
public class ItemRepository {

    //그냥 임시 저장소니까 static 사용하고 HashMap 쓴 것
    //멀티 쓰레드 환경에서는 hashmap 쓰면 안됨. ConcurrentHashMAp 써야지..
    //Long도 동시에 접근하면 값이 꼬일 수 있음.
    private static final Map<Long, Item> store = new HashMap<>();
    private static long sequance = 0L;

    public Item save(Item item){
        item.setId(++sequance);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id){
        return store.get(id);
    }

    public List<Item> findAll(){
        return new ArrayList<>(store.values());
    }
    //간단하게 이렇게만 만드는 거야..
    //사실 updateParam용은 따로 DTO 만들어주는 게 나음.
    //개발자가 어디까지 수정해야하는지 알 수 없기 때문
    public void update(Long itemId, Item updateParam){

        Item findItem = findById(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }
    public void clearStore(){
        store.clear();
    }
}
