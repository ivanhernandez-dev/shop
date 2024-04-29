package dev.ivanhernandez.apps.inventory.backend.controller.stock;

import dev.ivanhernandez.inventory.category.domain.CategoryAlreadyExist;
import dev.ivanhernandez.inventory.stocks.application.update.UpdateStockCommand;
import dev.ivanhernandez.shared.domain.DomainError;
import dev.ivanhernandez.shared.domain.bus.command.CommandBus;
import dev.ivanhernandez.shared.domain.bus.query.QueryBus;
import dev.ivanhernandez.shared.infrastructure.spring.ApiController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public final class StockPutController extends ApiController {
	public StockPutController(QueryBus queryBus, CommandBus commandBus) {
		super(queryBus, commandBus);
	}

	@PutMapping("/stocks/{shelfId}/{productId}")
	public void index(@PathVariable String shelfId, @PathVariable String productId, @RequestBody StockRequest request) {
		dispatch(new UpdateStockCommand(shelfId, request.quantity(), productId));
	}

	@Override
	public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
		return new HashMap<Class<? extends DomainError>, HttpStatus>();
	}
}
