json.array!(@dogs) do |dog|
  json.extract! dog, :id, :name, :breed
  json.url dog_url(dog, format: :json)
end
