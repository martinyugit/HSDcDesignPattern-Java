package com.hsdc.dp.service.domain.prototype;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hsdc.dp.intf.domain.prototype.ShallowPrototype;
import com.hsdc.dp.intf.domain.prototype.PurchaseOrder;
import com.hsdc.dp.intf.domain.prototype.PurchaseOrderLineItem;
import com.hsdc.dp.intf.service.prototype.MaintainPurchaseUco;

@Service
public class MaintainPurchaseUcoImpl implements MaintainPurchaseUco {

	public List<PurchaseOrder> getPurchaseLists() {
		return initialData();
	}
	
	private List<PurchaseOrder> initialData()
    {
        List<PurchaseOrder> poList = new ArrayList<PurchaseOrder>();
        List<PurchaseOrderLineItem> items = new ArrayList<PurchaseOrderLineItem>();
        PurchaseOrderLineItem item = PurchaseOrderLineItemDo.createInstance();
        item.setProductName("烏龜");
        item.setPrice(new BigDecimal(12));
        item.setQuantity(2);
        items.add(item);
        item = PurchaseOrderLineItemDo.createInstance();
        item.setProductName("小鳥");
        item.setPrice(new BigDecimal(15.2));
        item.setQuantity(1);
        items.add(item);
        PurchaseOrderDo po = PurchaseOrderDo.createInstance();
        po.setCustomerName("Arthur");
        po.setPoNumber("PO010001");
        po.setPurchaseOrderLineItem(items);
        poList.add(po);
        items = new ArrayList<PurchaseOrderLineItem>();
        item = PurchaseOrderLineItemDo.createInstance();
        item.setProductName("烏龜");
        item.setPrice(new BigDecimal(11.5));
        item.setQuantity(1);
        items.add(item);
        po = PurchaseOrderDo.createInstance();
        po.setCustomerName("Ringle");
        po.setPoNumber("PO010002");
        po.setPurchaseOrderLineItem(items);
        poList.add(po);
        return poList;
    }

	public ShallowPrototype<PurchaseOrder> newPurchaseOrder() {
		return PurchaseOrderDo.createInstance();
	}

	public List<PurchaseOrder> save(PurchaseOrder po) {
		List<PurchaseOrder> poList = initialData();
        po.setPoNumber("PO010003");
        poList.add(po);
        return poList;
	}

}
