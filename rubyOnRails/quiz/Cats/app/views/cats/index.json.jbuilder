json.array!(@cats) do |cat|
  json.extract! cat, :id, :name, :breed, :color
  json.url cat_url(cat, format: :json)
end
