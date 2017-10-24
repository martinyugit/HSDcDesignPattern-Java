package com.hsdc.dp.service.visitor;

import org.springframework.stereotype.Service;
import com.hsdc.dp.intf.service.visitor.VisitorUco;

@Service
public class VisitorUcoImpl implements VisitorUco {

	public void execute(String inputVisitor) {
        Element[] list = {new FOO(), new BAR(), new BAZ()};
        Visitor visitor = null;
        switch (Integer.parseInt(inputVisitor)) {
        case 1:
        	visitor = new UpVisitor();
        	break;
        case 2:
        	visitor = new DownVisitor();
        	break;
        }

        for (Element element : list) {
            element.accept(visitor);
        }
	}
}
