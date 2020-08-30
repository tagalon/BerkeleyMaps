import java.lang.reflect.Array;

import sun.tools.tree.ThisExpression;

public class Body {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public double GravitationalConstant = 6.67e-11;
    public Body(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }
    public Body(Body b) {
        xxPos = b.xxPos;
        yyPos = b.yyPos;
        xxVel = b.xxVel;
        yyVel = b.yyVel;
        mass = b.mass;
        imgFileName = b.imgFileName;
    }
    public double calcDistance(Body b2) {
        // double distance = Math.pow(Math.pow((this.xxPos - b2.xxPos), 2) + Math.pow((this.yyPos - b2.yyPos), 2), .5);
        double distance = Math.sqrt(Math.pow(this.xxPos - b2.xxPos, 2) + Math.pow(this.yyPos - b2.yyPos, 2));
        return distance;
    }
    public double calcForceExertedBy(Body b2) {
        if (this.equals(b2)) {
            return 0;
        }
        return (GravitationalConstant* this.mass * b2.mass) / Math.pow(this.calcDistance(b2), 2);
    }
    public double calcForceExertedByX(Body b2) {
        // double force = this.calcForceExertedBy(b2);
        if (this.calcForceExertedBy(b2) == 0) {
            return 0;
        }
        // double xComp = b2.xxPos - this.xxPos;
        return this.calcForceExertedBy(b2) * (b2.xxPos - this.xxPos) / this.calcDistance(b2);
    }
    public double calcForceExertedByY(Body b2) {
        // double force = this.calcForceExertedBy(b2);
        if (this.calcForceExertedBy(b2) == 0) {
            return 0;
        }
        // double yComp = b2.yyPos - this.yyPos;
        return this.calcForceExertedBy(b2) * (b2.yyPos - this.yyPos) / this.calcDistance(b2);
    }
    public double calcNetForceExertedByX(Body[] bodies) {
        double calcNetX= 0; 
        for (Body planet : bodies) {
            if (this.equals(planet)) {
                continue;
            }
            calcNetX += calcForceExertedByX(planet);
        }
        return calcNetX;
    }
    public double calcNetForceExertedByY(Body[] bodies) {
        double calcNetY = 0;
        for (Body planet : bodies) {
            if (this.equals(planet)) {
                continue;
            }
            calcNetY += calcForceExertedByY(planet);
        }
        return calcNetY;
    }
}