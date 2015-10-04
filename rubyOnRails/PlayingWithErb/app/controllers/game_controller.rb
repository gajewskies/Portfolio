class GameController < ApplicationController
  # START OF GAME
  def index

  end

  def check_one
    if params[:answer] == "Clear"
      # its right send to level 2
      redirect_to '/level2'
    else
      # its wrong send to level 1
      redirect_to '/game'
    end
  end

  def level_two

  end

  def check_two
    if params[:answer] == "Cece"
      # its right send to level 3
      redirect_to '/level3'
    else
      # its wrong send to level 1
      redirect_to '/game'
    end
  end

  def level_three

  end

  def check_three
    if params[:answer] == "Heda"
      # its right send to level 3
      redirect_to '/level4'
    else
      # its wrong send to level 1
      redirect_to '/game'
    end
  end

  def level_four

  end

  def check_four
    if params[:answer] == "Boulder"
      # its right send to level 3
      redirect_to '/level5'
    else
      # its wrong send to level 1
      redirect_to '/game'
    end
  end

  def level_five

  end

  def check_five
    if params[:answer] == "Suck It"
      # its right send to level 3
      redirect_to '/level5'
    else
      # its wrong send to level 1
      redirect_to '/game'
    end
  end

end
