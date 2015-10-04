class WelcomeController < ApplicationController

  def index
    # check if they provided the test param
    # as a number greater than 10
    @right_param = params[:test].to_i # to integer
    if @right_param > 10
      @right_param = true
    else
      @right_param = false
    end
  end

end
