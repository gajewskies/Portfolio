class ShowcaseController < ApplicationController
  def index
    @dogs = Dog.all
  end

  def specific
    @dog = Dog.find(params[:id])
  end
end
