from flask import Flask, request

app = Flask(__name__)

@app.route("/")
def hello():
    return "Hello, World!"

@app.route("/hello")
def hello_name():
    a = request.args
    return f"Hello, {a['name']}!"