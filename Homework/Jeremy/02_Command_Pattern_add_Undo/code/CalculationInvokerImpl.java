package com.hsdc.dp.service.command;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hsdc.dp.intf.service.command.CalculationInvoker;
import com.hsdc.dp.service.domain.command.Command;
import com.hsdc.dp.service.domain.command.ElementaryArithCommand;

@Service
public class CalculationInvokerImpl implements CalculationInvoker {
	private List<Command> commands = new LinkedList<Command>();

	public void compute(Object receiver, String operator, int operand) {
		// Create command operation and execute it
        Command command = new ElementaryArithCommand(receiver, operator, operand);
        command.execute();
        commands.add(command);
	}

	public void undo() {
		int size = commands.size();
		
		if(size > 0) {
			Command command = commands.get(size -1);
			command.unExecute();
			commands.remove(size -1);
		}
	}

}
