import os
import glob
import shutil


def publish(source: str, target: str) -> bool:
    """
    发布程序
    :param source: 编译的目录
    :param target: 发布的目录
    :return: 是否成功
    """
    # 判断目录是否存在
    mqtt_dir = os.path.abspath(os.path.join(source, "mqtt"))
    plugins_dir = os.path.abspath(os.path.join(source, "plugins"))
    if not os.path.isdir(mqtt_dir):
        print("没有找到mqtt目录，请确认本文件放在源程序的根目录下。\n")
        return False
    if not os.path.isdir(plugins_dir):
        print("没有找到plugins目录，请确认本文件放在源程序的根目录下。\n")
        return False
    # 判断mqtt的target目录是否存在
    mqtt_target_dir = os.path.abspath(os.path.join(mqtt_dir, "target"))
    if not os.path.isdir(mqtt_target_dir):
        print("mqtt模块没有target目录，请重新编译源程序。\n")
        return False
    # 查找jar包
    files = glob.glob(os.path.abspath(os.path.join(mqtt_target_dir, "mqtt-*-repackage.jar")))
    if len(files) == 0:
        print("mqtt模块的target目录中没有找到repackage后的jar包，请重新编译源程序。\n")
        return False
    # 拷贝jiar包
    file_name = os.path.basename(files[0])
    shutil.copyfile(files[0], os.path.abspath(os.path.join(target, file_name.replace("-repackage", ""))))
    # 建立目标的plugins目录
    target_plugins_dir = os.path.abspath(os.path.join(target, "plugins"))
    if not os.path.exists(target_plugins_dir):
        os.mkdir(target_plugins_dir)
    # 遍历plugins目录
    files = os.listdir(plugins_dir)
    for file in files:
        file_path = os.path.abspath(os.path.join(plugins_dir, file))
        if os.path.isdir(file_path):
            # 判断target目录是否存在
            target_dir = os.path.abspath(os.path.join(file_path, "target"))
            if not os.path.isdir(target_dir):
                print(file + "模块没有target目录，请重新编译源程序。\n")
                continue
            files = glob.glob(os.path.abspath(os.path.join(target_dir, "*-repackage.jar")))
            if len(files) == 0:
                print(file + "模块的target目录中没有找到repackage后的jar包，请重新编译源程序。\n")
                continue
            file_name = os.path.basename(files[0])
            shutil.copyfile(files[0],
                            os.path.abspath(os.path.join(target, "plugins", file_name.replace("-repackage", ""))))
    return True


if __name__ == '__main__':
    source_dir = os.getcwd()
    target_dir = os.path.abspath(os.path.join(source_dir, "../部署/mqtt/prod"))
    if publish(source_dir, target_dir):
        print("发布成功!\n")
    else:
        print("发布失败!\n")
