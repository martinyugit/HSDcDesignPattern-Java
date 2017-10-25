package com.hsdc.dp.service.adapter;

import org.springframework.stereotype.Service;

import com.hsdc.dp.intf.service.adapter.AdapterUco;
import com.hsdc.dp.intf.service.adapter.Shape;

@Service
public class AdapterUcoImpl implements AdapterUco {

	public void draw(int x1, int x2, int y1, int y2) {
		 System.out.println("x1=" + x1);
		 System.out.println("x2=" + x2);
		 System.out.println("y1=" + y1);
		 System.out.println("y2=" + y2);
		
		Shape[] shapes = { new RectangleAdapter(new Rectangle()), new LineAdapter(new Line()) };
		for (Shape shape : shapes) {
			shape.draw(x1, y1, x2, y2);
		}

	}
}
