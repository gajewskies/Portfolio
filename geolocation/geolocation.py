from geolocation.google_maps import GoogleMaps
from geolocation.distance_matrix import const

address = "98 w 4th st dunkirk ny 14048"
#origins = ["501 Woodrow Avenue Dunkirk New York 14048"]
#destinations = ['36 Center street Fredonia New York 14063']
google_maps = GoogleMaps(api_key='AIzaSyBDrUT23Cl31dLl-T6ZRPERYefp8-nH7bY') 
#items = google_maps.distance(origins, destinations).all()  # default mode parameter is const.MODE_DRIVING.
location = google_maps.search(location=address) # sends search to Google Maps.

print(location.all()) # returns all locations.

my_location = location.first() # returns only first location.

print(my_location.city)
print(my_location.route)
print(my_location.street_number)
print(my_location.postal_code)

for administrative_area in my_location.administrative_area:
    print("{}: {}".format(administrative_area.area_type, administrative_area.name))

print(my_location.country)
print(my_location.country_shortcut)

print(my_location.formatted_address)

print(my_location.lat)
print(my_location.lng)

# reverse geocode

lat = 40.7060008
lng = -74.0088189

"""
my_location = google_maps.search(lat=lat, lng=lng).first()

for item in items:
    print 'origin: %s' % item.origin
    print 'destination: %s' % item.destination
    print 'km: %s' % item.distance.kilometers
    print 'm: %s' % item.distance.meters
    print 'miles: %s' % item.distance.miles
    print 'duration: %s' % item.duration  # returns string.
    print 'duration datetime: %s' % item.duration.datetime  # returns datetime.

    # you can also get items from duration, returns int() values.
    print 'duration days: %s' % item.duration.days
    print 'duration hours: %s' % item.duration.hours
    print 'duration minutes: %s' % item.duration.minutes
    print 'duration seconds: %s' % item.duration.seconds
"""