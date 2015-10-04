json.array!(@posts) do |post|
  json.extract! post, :id, :title, :author, :body, :posted
  json.url post_url(post, format: :json)
end
