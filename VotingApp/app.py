from flask import Flask,render_template

app= Flask(__name__)

@app.route('/')
def webpage():
    return render_template('webpage.html')

@app.route('/favicon.ico')
def favicon():
    return send_from_directory(os.path.join(app.root_path, 'static'), 'favicon.ico', mimetype='images/pic05.jpg')

if __name__ == '__main__':
    app.run(debug= True,host="0.0.0.0", port=80)
