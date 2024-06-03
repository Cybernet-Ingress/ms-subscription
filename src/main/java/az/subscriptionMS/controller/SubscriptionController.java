package az.subscriptionMS.controller;

import az.subscriptionMS.model.Subscription;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import az.subscriptionMS.service.SubscriptionsService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class SubscriptionController {

	@Autowired
	private SubscriptionsService subscriptionsService;

    @ApiOperation(value = "New Subscription")
	@PostMapping("/subscriptions")
	public Subscription createSubscription(@RequestBody Subscription subscription) {
		return subscriptionsService.createSubscription(subscription);
	}
	@ApiOperation(value = "Get All Subscriptions")
	@GetMapping("/subscriptions")
	public ResponseEntity<List<Subscription>> getAllSubscriptions(){
		return ResponseEntity.ok(subscriptionsService.getAllSubscriptions());
	}
	@ApiOperation(value = "Get a Subscription by ID",notes = "Subscription ID value Interger")
	@GetMapping("/subscriptions/{id}")
	public Optional<Subscription> getSubscriptionById(@PathVariable @ApiParam(value = "Defualt ID 1") Long id){
		return subscriptionsService.getSubscription(id);
	}
	@ApiOperation(value = "Edit a Subscription by ID")
	@PutMapping("/subscriptions/{id}")
	public Subscription updateSubscription(@RequestBody Subscription subscription) {
		return subscriptionsService.updateSubscription(subscription);
	}
	@ApiOperation(value = "Delete a Subscription by ID")
	@DeleteMapping("/subscriptions/{id}")
	public void deleteSubscription(@PathVariable Long id) {
		subscriptionsService.deleteSubscription(id);
	}
}