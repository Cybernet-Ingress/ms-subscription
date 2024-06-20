package az.subscriptionMS.controller;

import az.subscriptionMS.model.Subscription;
import az.subscriptionMS.service.SubscriptionsService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/subscriptions")
@RequiredArgsConstructor
public class SubscriptionController {

	@Autowired
	private SubscriptionsService subscriptionsService;

    @ApiOperation(value = "New Subscription")
	@PostMapping("")
	public Subscription createSubscription(@RequestBody Subscription subscription) {
		return subscriptionsService.createSubscription(subscription);
	}
	@ApiOperation(value = "Get All Subscriptions")
	@GetMapping("")
	public ResponseEntity<List<Subscription>> getAllSubscriptions(){
		return ResponseEntity.ok(subscriptionsService.getAllSubscriptions());
	}
	@ApiOperation(value = "Get a Subscription by ID",notes = "Subscription ID value Interger")
	@GetMapping("/{id}")
	public Optional<Subscription> getSubscriptionById(@PathVariable @ApiParam(value = "Defualt ID 1") Long id){
		return subscriptionsService.getSubscription(id);
	}
	@ApiOperation(value = "Edit a Subscription by ID")
	@PutMapping("/{id}")
	public Subscription updateSubscription(@RequestBody Subscription subscription) {
		return subscriptionsService.updateSubscription(subscription);
	}
	@ApiOperation(value = "Delete a Subscription by ID")
	@DeleteMapping("/{id}")
	public void deleteSubscription(@PathVariable Long id) {
		subscriptionsService.deleteSubscription(id);
	}
}