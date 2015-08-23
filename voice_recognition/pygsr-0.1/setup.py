from setuptools import setup

setup(name = "pygsr",
      version = "0.1",
      description = "Simple way to access google api for speech recognition"
                    " with python",
      long_description=open('README.rst', 'r').read(),
      author = "Carlos Ganoza Plasencia",
      author_email = "cganozap@gmail.com",
      url = "https://bitbucket.org/drneox/pygsr",
      license = "GPL",
      packages=["pygsr"],
      keywords= "speech recognition",
      install_requires = ["pyaudio>=0.2.4"],

)