from ultralytics import YOLO
model = YOLO("F:/ultralytics-main/runs/detect/train5/weights/best.pt")
results=model.predict(source="F:/graduateProject/save/message.jpg", save=True,save_conf=True, save_txt=False, name='output')
