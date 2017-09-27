package com.hsdc.dp.service.domain.prototype;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hsdc.dp.intf.domain.prototype.DeepPrototype;
import com.hsdc.dp.intf.domain.prototype.PurchaseOrder;
import com.hsdc.dp.intf.domain.prototype.PurchaseOrderLineItem;
import com.hsdc.dp.intf.service.prototype.MaintainPurchaseOrderErpUco;

@Service
public class MaintainPurchaseOrderErpUcoImpl implements MaintainPurchaseOrderErpUco {

	public List<PurchaseOrder> getPurchaseLists() {
		return initialData();
	}
	
	private List<PurchaseOrder> initialData()
    {
        List<PurchaseOrder> poList = new ArrayList<PurchaseOrder>();
        List<PurchaseOrderLineItem> items = new ArrayList<PurchaseOrderLineItem>();
        PurchaseOrderLineItem item = PurchaseOrderLineItemErpDo.createInstance();
        item.setProductName("烏龜");
        item.setPrice(new BigDecimal(12));
        item.setQuantity(2);
        items.add(item);
        item = PurchaseOrderLineItemErpDo.createInstance();
        item.setProductName("小鳥");
        item.setPrice(new BigDecimal(15.2));
        item.setQuantity(1);
        items.add(item);
        PurchaseOrderErpDo po = PurchaseOrderErpDo.createInstance();
        po.setCustomerName("Arthur");
        po.setPoNumber("PO010001");
        po.setPurchaseOrderLineItem(items);
        poList.add(po);
        items = new ArrayList<PurchaseOrderLineItem>();
        item = PurchaseOrderLineItemErpDo.createInstance();
        item.setProductName("烏龜");
        item.setPrice(new BigDecimal(11.5));
        item.setQuantity(1);
        items.add(item);
        po = PurchaseOrderErpDo.createInstance();
        po.setCustomerName("Ringle");
        po.setPoNumber("PO010002");
        po.setPurchaseOrderLineItem(items);
        poList.add(po);
        return poList;
    }

	@SuppressWarnings("unchecked")
	public PurchaseOrder copyPo(String sourcePoNumber) {
		List<PurchaseOrder> sources = initialData();
		PurchaseOrder source = null;
		PurchaseOrder target = null;
		for (PurchaseOrder po : sources)
			if (po.getPoNumber().equals(sourcePoNumber))
				source = po;
		if (source != null)
        {
            target = ((DeepPrototype<PurchaseOrder>)source).deepClone();
            target.setPoNumber( "");
        }
		return target;
	}

	public List<PurchaseOrder> save(PurchaseOrder po) {
		List<PurchaseOrder> poList = initialData();
        po.setPoNumber("PO010003");
        poList.add(po);
        return poList;
	}

}
