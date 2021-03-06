package map_imgs;

import helper.ParseImgName;

/**
 * Created by moveb on 2018/8/30.
 * 将多层次的图片块构造为 四分树
 */
public class QuadTree {
    private Tile root;

    // 递归构造 四分树
    public QuadTree(){
        root = new Tile();
        root.setName("d0_x0_y0");
        root.setDepth(0);
        root.setUllon(-122.2998046875);
        root.setLrlon(-122.2119140625);
        root.setUllat(37.892195547244356);
        root.setLrlat(37.82280243352756);
        gen(root);
    }

    /**
     * d1_x0_y0
     * 以p为根节点的完整的四分树
     * @param p
     * @return
     */
    public Tile gen(Tile p){
        if(p.getDepth() == 7){
            return p;
        }
        String sufixOfX = ParseImgName.sufixOfX(p.getName());
        String sufixOfY = ParseImgName.sufixOfY(p.getName());
        int depth = p.getDepth() + 1;
		// p的四个分支
        Tile nw4p = new Tile();
        Tile ne4p = new Tile();
        Tile sw4p = new Tile();
        Tile se4p = new Tile();

        nw4p.setDepth(depth);
        ne4p.setDepth(depth);
        sw4p.setDepth(depth);
        se4p.setDepth(depth);

        nw4p.setParent(p);
        ne4p.setParent(p);
        sw4p.setParent(p);
        se4p.setParent(p);

        nw4p.setPos(1);
        ne4p.setPos(2);
        sw4p.setPos(3);
        se4p.setPos(4);

        double midLon = (p.getUllon() + p.getLrlon())/2;
        double midLat = (p.getUllat() + p.getLrlat())/2;
        // 设置经纬度
        nw4p.setUllon(p.getUllon());
        nw4p.setUllat(p.getUllat());
        nw4p.setLrlon(midLon);
        nw4p.setLrlat(midLat);

        ne4p.setUllon(midLon);
        ne4p.setUllat(p.getUllat());
        ne4p.setLrlon(p.getLrlon());
        ne4p.setLrlat(midLat);

        sw4p.setUllon(p.getUllon());
        sw4p.setUllat(midLat);
        sw4p.setLrlon(midLon);
        sw4p.setLrlat(p.getLrlat());

        se4p.setUllon(midLon);
        se4p.setUllat(midLat);
        se4p.setLrlon(p.getLrlon());
        se4p.setLrlat(p.getLrlat());

        // 与图片名绑定
        int x = Integer.parseInt(sufixOfX) * 2;
        int y = Integer.parseInt(sufixOfY) * 2;
        nw4p.setName(ParseImgName.consImgName(depth+"", x+"", y+""));
        ne4p.setName(ParseImgName.consImgName(depth+"", x+1+"", y+""));
        sw4p.setName(ParseImgName.consImgName(depth+"", x+"", y+1+""));
        se4p.setName(ParseImgName.consImgName(depth+"", x+1+"", y+1+""));

        p.setNw(nw4p);
        p.setNe(ne4p);
        p.setSw(sw4p);
        p.setSe(se4p);

        gen(nw4p);
        gen(ne4p);
        gen(sw4p);
        gen(se4p);
        return p;
    }

    public Tile getRoot() {
        return root;
    }

    public void setRoot(Tile root) {
        this.root = root;
    }


}
