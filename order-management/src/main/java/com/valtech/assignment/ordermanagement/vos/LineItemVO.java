package com.valtech.assignment.ordermanagement.vos;

import java.util.List;
import java.util.stream.Collectors;

import com.valtech.assignment.ordermanagement.entities.Item;
import com.valtech.assignment.ordermanagement.entities.LineItems;
import com.valtech.assignment.ordermanagement.entities.Order;

public record LineItemVO(int lineItemId,Item item,int quantity,Order order) {

    
    public static LineItemVO from(LineItems li) {
        return new LineItemVO(li.getLineItemId(),li.getItem(),li.getQuentity(),li.getOrder());
    }

    public static List<LineItemVO> from(List<LineItems> lis){
    	return lis.stream().map(l -> LineItemVO.from(l)).collect(Collectors.toList());
    }
   
    public LineItems to() {
      return  new LineItems(lineItemId, quantity, item, order);
    }
}


