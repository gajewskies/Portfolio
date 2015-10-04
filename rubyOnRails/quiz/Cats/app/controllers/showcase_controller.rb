class ShowcaseController < ApplicationController

  def index
    @cats = Cat.all
  end

  def specific
    @cat = Cat.find(params[:id])
  end

end
