class WebController < ApplicationController
	# define our methods
	def index
	
	end
	
	def about
		
	end
	
	def puppies
		# without the @ makes this array local
		# the @ makes an instance variable, making an object of the controller
		# making the array available to anyone within this controller
		@puppy_names = [
			'sami', 
			'chentel', 
			'jacque', 
			'star', 
			'turbo', 
			'spock', 
			'spot'
		];
	end
	
end
