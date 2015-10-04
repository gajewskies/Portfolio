class CreatePosts < ActiveRecord::Migration
  def change
    create_table :posts do |t|
      t.string :title
      t.string :author
      t.string :body
      t.date :posted

      t.timestamps null: false
    end
  end
end
