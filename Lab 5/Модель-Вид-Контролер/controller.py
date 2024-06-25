from model import Model
from view import View

class Controller:
    def __init__(self, model, view):
        self.model = model
        self.view = view

    def update_view(self):
        data = self.model.get_data()
        self.view.show_data(data)

if __name__ == "__main__":
    model = Model()
    view = View()
    controller = Controller(model, view)
    controller.update_view()
