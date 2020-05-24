import flask 
from flask import request, jsonify
import pymysql.cursors

app = flask.Flask(__name__)
app.config["DEBUG"] = True


@app.route('/api/v1/resources/persons', methods=['GET'])
def api_all():
    query_parameters = request.args

    rut=query_parameters.get('RUT')
    conn = pymysql.connect(host='localhost', user='root',password='root',db='appmoviles',cursorclass=pymysql.cursors.DictCursor)

    try:
        with conn.cursor() as cursor:
            query = "select * from `tbpersonas` ;"
            cursor.execute(query,rut)
            result= cursor.fetchall()
            return jsonify(result)
    finally:
        conn.close()
    return jsonify(persons)

@app.route('/api/v1/resources/persons',methods=['GET'])
def api_filter():
    query_parameters = request.args

    rut=query_parameters.get('RUT')
    conn = pymysql.connect(host='localhost', user='root',password='root',db='appmoviles',cursorclass=pymysql.cursors.DictCursor)

    try:
        with conn.cursor() as cursor:
            query = "select * from `tbpersonas` where `RUT` = %s;"
            cursor.execute(query,rut)
            result= cursor.fetchone()
            return jsonify(result)
    finally:
        conn.close()

app.run()