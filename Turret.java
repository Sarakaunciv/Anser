
{
        duo = new ItemTurret("duo"){{
            requirements(Category.turret, with(Items.copper, 35));
            ammo(
                Items.copper,  new BasicBulletType(8f, 9){{
                    width = 7f;
                    height = 9f;
                    lifetime = 65f;
                    ammoMultiplier = 10 * 2;

                    hitEffect = despawnEffect = Fx.hitBulletColor;
                    hitColor = backColor = trailColor = Pal.copperAmmoBack;
                    frontColor = Pal.copperAmmoFront;
                    
                    buildingDamageMultiplier = 0f; //add
                }},
                Items.graphite, new BasicBulletType(8f, 18){{
                    width = 9f;
                    height = 12f;
                    ammoMultiplier = 10 * 4;
                    lifetime = 65f;
                    reloadMultiplier = 0.8f;
                    rangeChange = 16f;

                    hitEffect = despawnEffect = Fx.hitBulletColor;
                    hitColor = backColor = trailColor = Pal.graphiteAmmoBack;
                    frontColor = Pal.graphiteAmmoFront;
                    
                    buildingDamageMultiplier = 0f; //add
                }},
                Items.silicon, new BasicBulletType(8f, 12){{
                    width = 7f;
                    height = 9f;
                    homingPower = 0.5f; //edit
                    reloadMultiplier = 1.5f;
                    ammoMultiplier = 10 * 5;
                    lifetime = 65f;

                    trailLength = 5;
                    trailWidth = 1.5f;

                    hitEffect = despawnEffect = Fx.hitBulletColor;
                    hitColor = backColor = trailColor = Pal.siliconAmmoBack;
                    frontColor = Pal.siliconAmmoFront;
                    
                    buildingDamageMultiplier = 0f; //add
                }}
            );

            shoot = new ShootAlternate(3.5f);

            recoils = 2;
            drawer = new DrawTurret(){{
                for(int i = 0; i < 2; i ++){
                    int f = i;
                    parts.add(new RegionPart("-barrel-" + (i == 0 ? "l" : "r")){{
                        progress = PartProgress.recoil;
                        recoilIndex = f;
                        under = true;
                        moveY = -1.5f;
                    }});
                }
            }};

            shootSound = Sounds.shootDuo;
            recoil = 0.5f;
            shootY = 3f;
            reload = 20f;
            range = 3 * 160;
            shootCone = 15f;
            ammoUseEffect = Fx.casing1;
            health = 250;
            inaccuracy = 0f; //edit
            rotateSpeed = 10f;
            coolant = consumeCoolant(0.1f);
            coolantMultiplier = 10f;
            researchCostMultiplier = 0.05f;
            depositCooldown = 2.0f;

            limitRange(5f);
        }};

        scatter = new ItemTurret("scatter"){{
            requirements(Category.turret, with(Items.copper, 85, Items.lead, 45));
            ammo(
                Items.scrap, new FlakBulletType(12f, 3){{
                    lifetime = 60f;
                    ammoMultiplier = 10 * 5f;
                    shootEffect = Fx.shootSmall;
                    reloadMultiplier = 0.5f;
                    width = 6f;
                    height = 8f;
                    hitEffect = Fx.flakExplosion;
                    splashDamage = 22f * 1.5f;
                    splashDamageRadius = 24f;

                    frontColor = Pal.scrapAmmoFront;
                    backColor = hitColor = Pal.scrapAmmoBack;
                    despawnEffect = Fx.hitBulletColor;
                }},
                Items.lead, new FlakBulletType(12f, 3){{
                    lifetime = 60f;
                    ammoMultiplier = 10 * 4f;
                    shootEffect = Fx.shootSmall;
                    width = 6f;
                    height = 8f;
                    hitEffect = Fx.flakExplosion;
                    splashDamage = 27f * 1.5f;
                    splashDamageRadius = 15f;
                }},
                Items.metaglass, new FlakBulletType(12f, 3){{
                    backColor = trailColor = Pal.glassAmmoBack;
                    hitColor = frontColor = Pal.glassAmmoFront;
                    despawnEffect = Fx.hitBulletColor;

                    lifetime = 60f;
                    ammoMultiplier = 10 * 5f;
                    shootEffect = Fx.shootSmall;
                    reloadMultiplier = 0.8f;
                    width = 6f;
                    height = 8f;
                    hitEffect = Fx.flakExplosion;
                    splashDamage = 30f * 1.5f;
                    splashDamageRadius = 20f;
                    fragBullets = 6;
                    fragBullet = new BasicBulletType(8f, 5){{
                        width = 5f;
                        height = 12f;
                        shrinkY = 1f;
                        lifetime = 20f;
                        backColor = trailColor = Pal.glassAmmoBack;
                        hitColor = frontColor = Pal.glassAmmoFront;
                        despawnEffect = Fx.none;
                        collidesGround = false;
                    }};
                }}
            );

            drawer = new DrawTurret(){{
                parts.add(new RegionPart("-mid"){{
                    progress = PartProgress.recoil;
                    under = false;
                    moveY = -1.25f;
                }});
            }};

            reload = 18f;
            range = 3 * 220f;
            size = 2;
            targetGround = false;

            shoot.shotDelay = 5f;
            shoot.shots = 2;

            recoil = 1f;
            rotateSpeed = 15f;
            inaccuracy = 2f; //edit
            shootCone = 35f;

            scaledHealth = 200;
            shootSound = Sounds.shootScatter;
            coolant = consumeCoolant(0.2f);
            researchCostMultiplier = 0.05f;
            depositCooldown = 0.5f;

            limitRange(2);
        }};

        scorch = new ItemTurret("scorch"){{
            requirements(Category.turret, with(Items.copper, 25, Items.graphite, 22));
            ammo(
                Items.coal, new BulletType(8f, 17f){{
                    ammoMultiplier = 10 * 3f;
                    hitSize = 7f;
                    lifetime = 30f;
                    pierce = true;
                    collidesAir = false;
                    statusDuration = 60f * 4;
                    shootEffect = Fx.shootSmallFlame;
                    hitEffect = Fx.hitFlameSmall;
                    despawnEffect = Fx.none;
                    status = StatusEffects.burning;
                    hittable = false;
                    
                    buildingDamageMultiplier = 0f; //add
                }},
                Items.pyratite, new BulletType(8f, 30f){{
                    ammoMultiplier = 10 * 10f;
                    hitSize = 7f;
                    lifetime = 30;
                    pierce = true;
                    collidesAir = false;
                    statusDuration = 60f * 10;
                    shootEffect = Fx.shootPyraFlame;
                    hitEffect = Fx.hitFlameSmall;
                    despawnEffect = Fx.none;
                    status = StatusEffects.burning;
                    hittable = false;
                    
                    buildingDamageMultiplier = 0f; //add
                }}
            );
            recoil = 0f;
            reload = 6f;
            coolantMultiplier = 1.5f;
            range = 3 * 60f;
            shootY = 3;
            shootCone = 50f;
            targetAir = false;
            ammoUseEffect = Fx.none;
            health = 400;
            shootSound = Sounds.shootFlame;
            coolant = consumeCoolant(0.1f);
            depositCooldown = 1.0f;
        }};

        hail = new ItemTurret("hail"){{
            requirements(Category.turret, with(Items.copper, 40, Items.graphite, 17));
            ammo(
                Items.graphite, new ArtilleryBulletType(9f, 20){{
                    knockback = 0.8f;
                    lifetime = 80f;
                    width = height = 11f;
                    collidesTiles = false;
                    splashDamageRadius = 25f * 0.75f;
                    splashDamage = 33f;

                    hitColor = backColor = trailColor = Pal.graphiteAmmoBack;
                    frontColor = Pal.graphiteAmmoFront;
                    despawnEffect = Fx.hitBulletColor;
                    
                    buildingDamageMultiplier = 0f; //add
                }},
                Items.silicon, new ArtilleryBulletType(9f, 20){{
                    knockback = 0.8f;
                    lifetime = 80f;
                    width = height = 11f;
                    collidesTiles = false;
                    splashDamageRadius = 25f * 0.75f;
                    splashDamage = 33f;
                    reloadMultiplier = 1.2f;
                    ammoMultiplier = 10 * 3f;
                    homingPower = 0.2f; //edit
                    homingRange = 50f;

                    trailLength = 7;
                    trailWidth = 3f;

                    hitColor = backColor = trailColor = Pal.siliconAmmoBack;
                    frontColor = Pal.siliconAmmoFront;
                    despawnEffect = Fx.hitBulletColor;
                    
                    buildingDamageMultiplier = 0f; //add
                }},
                Items.pyratite, new ArtilleryBulletType(9f, 25){{
                    hitEffect = Fx.blastExplosion;
                    knockback = 0.8f;
                    lifetime = 80f;
                    width = height = 13f;
                    collidesTiles = false;
                    splashDamageRadius = 25f * 0.75f;
                    splashDamage = 45f;
                    status = StatusEffects.burning;
                    statusDuration = 60f * 12f;
                    frontColor = trailColor = hitColor = Pal.lightishOrange;
                    backColor = Pal.lightOrange;
                    makeFire = true;
                    trailEffect = Fx.incendTrail;
                    ammoMultiplier = 10 * 4f;
                    despawnEffect = Fx.hitBulletColor;
                    
                    buildingDamageMultiplier = 0f; //add
                }}
            );
            targetAir = false;
            reload = 60f;
            recoil = 2f;
            range = 3 * 235f;
            inaccuracy = 0f; //edit
            shootCone = 10f;
            health = 260;
            shootSound = Sounds.shootArtillerySmall;
            coolant = consumeCoolant(0.1f);
            coolantMultiplier = 10f;
            depositCooldown = 2.0f;
            limitRange(0f);
        }};

        wave = new LiquidTurret("wave"){{
            requirements(Category.turret, with(Items.metaglass, 45, Items.lead, 75, Items.copper, 25));
            ammo(
                Liquids.water,new LiquidBulletType(Liquids.water){{
                    lifetime = 3 * 20;
                    knockback = 0.7f;
                    drag = 0.01f;
                    layer = Layer.bullet - 2f;
                }},
                Liquids.slag, new LiquidBulletType(Liquids.slag){{
                    lifetime = 3 * 20;
                    damage = 4;
                    drag = 0.01f;
                }},
                Liquids.cryofluid, new LiquidBulletType(Liquids.cryofluid){{
                    lifetime = 3 * 20;
                    drag = 0.01f;
                }},
                Liquids.oil, new LiquidBulletType(Liquids.oil){{
                    lifetime = 3 * 20;
                    drag = 0.01f;
                    layer = Layer.bullet - 2f;
                }}
            );
            size = 2;
            recoil = 0f;
            reload = 3f;
            inaccuracy = 5f;
            shootCone = 50f;
            liquidCapacity = 10f;
            shootEffect = Fx.shootLiquid;
            range = 3 * 110f;
            scaledHealth = 250;
            flags = EnumSet.of(BlockFlag.turret, BlockFlag.extinguisher);
        }};

        lancer = new PowerTurret("lancer"){{
            requirements(Category.turret, with(Items.copper, 60, Items.lead, 70, Items.silicon, 60, Items.titanium, 30));
            range = 3 * 165f;

            shoot.firstShotDelay = 40f;

            recoil = 2f;
            reload = 80f;
            shake = 2f;
            shootEffect = Fx.lancerLaserShoot;
            smokeEffect = Fx.none;
            heatColor = Color.red;
            size = 2;
            scaledHealth = 280;
            targetAir = false;
            moveWhileCharging = false;
            accurateDelay = false;
            shootSound = Sounds.shootLancer;
            coolant = consumeCoolant(0.2f);
            chargeSound = Sounds.chargeLancer;

            consumePower(6f);

            shootType = new LaserBulletType(140){{
                colors = new Color[]{Pal.lancerLaser.cpy().a(0.4f), Pal.lancerLaser, Color.white};
                //TODO merge
                chargeEffect = new MultiEffect(Fx.lancerLaserCharge, Fx.lancerLaserChargeBegin);

                buildingDamageMultiplier = 0f;
                armorMultiplier = 4f;
                hitEffect = Fx.hitLancer;
                hitSize = 4;
                lifetime = 16f;
                drawSize = 400f;
                collidesAir = false;
                length = 3 * 173f;
                ammoMultiplier = 1f;
                pierceCap = 4;
                
                buildingDamageMultiplier = 0f; //add
            }};
        }};

        arc = new PowerTurret("arc"){{
            requirements(Category.turret, with(Items.copper, 50, Items.lead, 50));
            shootType = new LightningBulletType(){{
                damage = 12;
                lightningLength = 3 * 25;
                collidesAir = false;
                ammoMultiplier = 1f;
                
                buildingDamageMultiplier = 0f; //add

                //for visual stats only.
                buildingDamageMultiplier = 0f;
                pierceCap = 5;

                lightningType = new BulletType(0.0001f, 0f){{
                    lifetime = Fx.lightning.lifetime;
                    hitEffect = Fx.hitLancer;
                    despawnEffect = Fx.none;
                    status = StatusEffects.shocked;
                    hittable = false;
                    lightColor = Color.white;
                    collidesAir = false;
                    buildingDamageMultiplier = 0f;
                    shieldDamageMultiplier = 0.2f;
                }};
            }};
            researchCostMultiplier = 1/3f;
            reload = 35f;
            shootCone = 40f;
            rotateSpeed = 8f;
            targetAir = false;
            range = 3 * 90f;
            shootEffect = Fx.lightningShoot;
            heatColor = Color.red;
            recoil = 1f;
            size = 1;
            health = 260;
            shootSound = Sounds.shootArc;

            consumePower(3.3f);
            coolant = consumeCoolant(0.1f);
            coolantMultiplier = 30f;
        }};

        parallax = new TractorBeamTurret("parallax"){{
            requirements(Category.turret, with(Items.silicon, 160, Items.titanium, 110, Items.graphite, 50));

            hasPower = true;
            size = 2;
            force = 3 * 16f;//edit
            scaledForce = 9f;
            range = 3 * 300f;
            damage = 3 * 0.5f;//edit
            scaledHealth = 160;
            rotateSpeed = 12;

            consumePower(3.3f);
        }};

        swarmer = new ItemTurret("swarmer"){{
            requirements(Category.turret, with(Items.graphite, 35, Items.titanium, 35, Items.plastanium, 45, Items.silicon, 30));
            ammo(
                Items.blastCompound, new MissileBulletType(3 * 3.7f, 10){{
                    width = 8f;
                    height = 8f;
                    shrinkY = 0f;
                    splashDamageRadius = 30f;
                    splashDamage = 30f * 1.5f;
                    ammoMultiplier = 10 * 5f;
                    hitEffect = Fx.blastExplosion;
                    despawnEffect = Fx.blastExplosion;

                    status = StatusEffects.blasted;

                    hitColor = backColor = trailColor = Pal.blastAmmoBack;
                    frontColor = Pal.blastAmmoFront;
                    
                    buildingDamageMultiplier = 0f; //add
                }},
                Items.pyratite, new MissileBulletType(3 * 3.7f, 12){{
                    frontColor = Pal.lightishOrange;
                    backColor = Pal.lightOrange;
                    width = 7f;
                    height = 8f;
                    shrinkY = 0f;
                    homingPower = 0.08f;
                    splashDamageRadius = 20f;
                    splashDamage = 30f * 1.5f;
                    makeFire = true;
                    ammoMultiplier = 10 * 5f;
                    hitEffect = Fx.blastExplosion;
                    status = StatusEffects.burning;
                    
                    buildingDamageMultiplier = 0f; //add
                }},
                Items.surgeAlloy, new MissileBulletType(3 * 3.7f, 18){{
                    width = 8f;
                    height = 8f;
                    shrinkY = 0f;
                    splashDamageRadius = 25f;
                    splashDamage = 25f * 1.4f;
                    hitEffect = Fx.blastExplosion;
                    despawnEffect = Fx.blastExplosion;
                    ammoMultiplier = 10 * 4f;
                    lightningDamage = 10;
                    lightning = 2;
                    lightningLength = 10;

                    hitColor = backColor = trailColor = Pal.surgeAmmoBack;
                    frontColor = Pal.surgeAmmoFront;
                    
                    buildingDamageMultiplier = 0f; //add
                }}
            );

            shoot = new ShootBarrel(){{
                barrels = new float[]{
                    -4, -1.25f, 0,
                    0, 0, 0,
                    4, -1.25f, 0
                };
                shots = 4;
                shotDelay = 5f;
            }};

            shootY = 4.5f;
            reload = 60f * 4f / 7f;
            inaccuracy = 2f;
            range = 3 * 240f;
            consumeAmmoOnce = false;
            size = 2;
            scaledHealth = 300;
            shootSound = Sounds.shootMissile;
            envEnabled |= Env.space;
            rotateSpeed = 4f;

            limitRange(5f);
            coolant = consumeCoolant(0.3f);
            depositCooldown = 2.0f;
        }};

        salvo = new ItemTurret("salvo"){{
            requirements(Category.turret, with(Items.copper, 100, Items.graphite, 80, Items.titanium, 50));
            ammo(
                Items.copper,  new BasicBulletType(10f, 15){{
                    width = 7f;
                    height = 9f;
                    lifetime = 60f;
                    ammoMultiplier = 10 * 5;
                    armorMultiplier = 1.5f;

                    hitEffect = despawnEffect = Fx.hitBulletColor;
                    hitColor = backColor = trailColor = Pal.copperAmmoBack;
                    frontColor = Pal.copperAmmoFront;
                    buildingDamageMultiplier = 0f; //add
                }},
                Items.graphite, new BasicBulletType(10f, 31){{
                    width = 9f;
                    height = 12f;
                    ammoMultiplier = 10 * 4;
                    lifetime = 60f;
                    reloadMultiplier = 0.8f;

                    rangeChange = 4f * 8f;

                    hitEffect = despawnEffect = Fx.hitBulletColor;
                    hitColor = backColor = trailColor = Pal.graphiteAmmoBack;
                    frontColor = Pal.graphiteAmmoFront;
                    buildingDamageMultiplier = 0f; //add
                }},
                Items.pyratite, new BasicBulletType(10f, 25){{
                    width = 10f;
                    height = 12f;
                    frontColor = hitColor = Pal.lightishOrange;
                    backColor = Pal.lightOrange;
                    status = StatusEffects.burning;
                    hitEffect = new MultiEffect(Fx.hitBulletColor, Fx.fireHit);

                    ammoMultiplier = 10 * 5;

                    splashDamage = 15f;
                    splashDamageRadius = 22f;

                    makeFire = true;
                    lifetime = 60f;
                    buildingDamageMultiplier = 0f; //add
                }},
                Items.silicon, new BasicBulletType(10f, "bullet"){{
                    width = 8f;
                    height = 10f;
                    homingPower = 0.5f;//edit
                    reloadMultiplier = 1.5f;
                    ammoMultiplier = 10 * 5;
                    lifetime = 60f;

                    trailLength = 5;
                    trailWidth = 1.5f;
                    hitEffect = despawnEffect = Fx.hitBulletColor;
                    hitColor = backColor = trailColor = Pal.siliconAmmoBack;
                    frontColor = Pal.siliconAmmoFront;
                    buildingDamageMultiplier = 0f; //add
                }},
                Items.thorium, new BasicBulletType(8f, "bullet"){{
                    width = 8f;
                    height = 13f;
                    shootEffect = Fx.shootBig;
                    smokeEffect = Fx.shootBigSmoke;
                    ammoMultiplier = 10 * 4;
                    lifetime = 60f;
                    armorMultiplier = 0.8f;

                    hitEffect = despawnEffect = Fx.hitBulletColor;
                    backColor = hitColor = trailColor = Pal.thoriumAmmoBack;
                    frontColor = Pal.thoriumAmmoFront;
                    buildingDamageMultiplier = 0f; //add
                }}
            );

            drawer = new DrawTurret(){{
                parts.add(new RegionPart("-side"){{
                    progress = PartProgress.warmup;
                    moveX = 0.6f;
                    moveRot = -15f;
                    mirror = true;
                    layerOffset = 0.001f;
                    moves.add(new PartMove(PartProgress.recoil, 0.5f, -0.5f, -8f));
                }}, new RegionPart("-barrel"){{
                    progress = PartProgress.recoil;
                    moveY = -2.5f;
                }});
            }};

            size = 2;
            range = 3 * 190f;
            reload = 29f;
            consumeAmmoOnce = false;
            ammoEjectBack = 3f;
            recoil = 0f;
            shake = 1f;
            shoot.shots = 4;
            shoot.shotDelay = 3f;

            ammoUseEffect = Fx.casing2;
            scaledHealth = 240;
            shootSound = Sounds.shootSalvo;

            limitRange();
            coolant = consumeCoolant(0.2f);
            depositCooldown = 2.0f;
        }};

        segment = new PointDefenseTurret("segment"){{
            requirements(Category.turret, with(Items.silicon, 130, Items.thorium, 80, Items.phaseFabric, 40, Items.titanium, 40));

            scaledHealth = 250;
            range = 3 * 180f;
            hasPower = true;
            consumePower(8f);
            size = 2;
            shootLength = 5f;
            bulletDamage = 30f;
            reload = 8f;
            envEnabled |= Env.space;
        }};

        tsunami = new LiquidTurret("tsunami"){{
            requirements(Category.turret, with(Items.metaglass, 100, Items.lead, 400, Items.titanium, 250, Items.thorium, 100));
            ammo(
                Liquids.water, new LiquidBulletType(Liquids.water){{
                    lifetime = 3 * 49f;
                    speed = 4f;
                    knockback = 1.7f;
                    puddleSize = 8f;
                    orbSize = 4f;
                    drag = 0.001f;
                    ammoMultiplier = 10 * 0.4f;
                    statusDuration = 60f * 4f;
                    damage = 0.2f;
                    layer = Layer.bullet - 2f;
                }},
                Liquids.slag, new LiquidBulletType(Liquids.slag){{
                    lifetime = 3 * 49f;
                    speed = 4f;
                    knockback = 1.3f;
                    puddleSize = 8f;
                    orbSize = 4f;
                    damage = 4.75f;
                    drag = 0.001f;
                    ammoMultiplier = 10 * 0.4f;
                    statusDuration = 60f * 4f;
                }},
                Liquids.cryofluid, new LiquidBulletType(Liquids.cryofluid){{
                    lifetime = 3 * 49f;
                    speed = 4f;
                    knockback = 1.3f;
                    puddleSize = 8f;
                    orbSize = 4f;
                    drag = 0.001f;
                    ammoMultiplier = 10 * 0.4f;
                    statusDuration = 60f * 4f;
                    damage = 0.2f;
                }},
                Liquids.oil, new LiquidBulletType(Liquids.oil){{
                    lifetime = 3 * 49f;
                    speed = 4f;
                    knockback = 1.3f;
                    puddleSize = 8f;
                    orbSize = 4f;
                    drag = 0.001f;
                    ammoMultiplier = 10 * 0.4f;
                    statusDuration = 60f * 4f;
                    damage = 0.2f;
                    layer = Layer.bullet - 2f;
                }}
            );
            size = 3;
            reload = 3f;
            shoot = new ShootAlternate(4f);
            shoot.shots = 2;
            velocityRnd = 0.1f;
            inaccuracy = 3f;
            recoil = 1f;
            shootCone = 45f;
            liquidCapacity = 40f;
            shootEffect = Fx.shootLiquid;
            range = 3 * 190f;
            scaledHealth = 250;
            flags = EnumSet.of(BlockFlag.turret, BlockFlag.extinguisher);
        }};

        fuse = new ItemTurret("fuse"){{
            requirements(Category.turret, with(Items.copper, 225, Items.graphite, 225, Items.thorium, 100));

            reload = 35f;
            shake = 4f;
            range = 3 * 90f;
            recoil = 5f;

            shoot = new ShootSpread(3, 20f);

            shootCone = 30;
            size = 3;
            envEnabled |= Env.space;

            scaledHealth = 220;
            shootSound = Sounds.shootFuse;
            shootSoundVolume = 0.9f;
            coolant = consumeCoolant(0.3f);

            float brange = range + 10f;

            ammo(
                Items.titanium, new ShrapnelBulletType(){{
                    length = brange;
                    damage = 66f;
                    ammoMultiplier = 10 * 4f;
                    width = 17f;
                    reloadMultiplier = 1.3f;
                    buildingDamageMultiplier = 0f; //add
                }},
                Items.thorium, new ShrapnelBulletType(){{
                    length = brange;
                    damage = 105f;
                    ammoMultiplier = 10 * 5f;
                    toColor = Pal.thoriumPink;
                    shootEffect = smokeEffect = Fx.thoriumShoot;
                    buildingDamageMultiplier = 0f; //add
                }}
            );
            depositCooldown = 1.0f;
        }};

        ripple = new ItemTurret("ripple"){{
            requirements(Category.turret, with(Items.copper, 150, Items.graphite, 135, Items.titanium, 60));
            ammo(
                Items.graphite, new ArtilleryBulletType(3 * 3f, 40){{
                    hitEffect = new MultiEffect(Fx.flakExplosion, Fx.shockwaveSmaller);
                    knockback = 0.8f;
                    lifetime = 80f;
                    width = 12f;
                    height = 14f;
                    collidesTiles = false;
                    splashDamageRadius = 30f * 0.75f;
                    splashDamage = 70f;

                    backColor = hitColor = trailColor = Pal.graphiteAmmoBack;
                    frontColor = Pal.graphiteAmmoFront;
                    despawnEffect = Fx.hitBulletColor;
                    lifeScaleRandMax = 1.08f;
                    lifeScaleRandMin = 0.95f;
                    buildingDamageMultiplier = 0f; //add
                }},
                Items.silicon, new ArtilleryBulletType(3 * 3f, 40){{
                    hitEffect = new MultiEffect(Fx.flakExplosion, Fx.shockwaveSmaller);
                    knockback = 0.8f;
                    lifetime = 80f;
                    width = 12f;
                    height = 14f;
                    collidesTiles = false;
                    splashDamageRadius = 30f * 0.75f;
                    splashDamage = 70f;
                    reloadMultiplier = 1.2f;
                    ammoMultiplier = 10 * 3f;
                    homingPower = 0.5f;//edit
                    homingRange = 50f;

                    trailLength = 9;
                    trailWidth = 3.1f;

                    despawnEffect = Fx.hitBulletColor;
                    backColor = hitColor = trailColor = Pal.siliconAmmoBack;
                    frontColor = Pal.siliconAmmoFront;
                    lifeScaleRandMax = 1.08f;
                    lifeScaleRandMin = 0.95f;

                    unitSort = UnitSorts.closest;
                    buildingDamageMultiplier = 0f; //add
                }},
                Items.pyratite, new ArtilleryBulletType(3 * 3f, 48){{
                    hitEffect = new MultiEffect(Fx.blastExplosion, Fx.shockwave);
                    knockback = 0.8f;
                    lifetime = 80f;
                    width = 13f;
                    height = 15f;
                    collidesTiles = false;
                    splashDamageRadius = 30f * 0.75f;
                    splashDamage = 90f;
                    status = StatusEffects.burning;
                    statusDuration = 60f * 12f;
                    frontColor = Pal.lightishOrange;
                    backColor = hitColor = Pal.lightOrange;
                    makeFire = true;
                    trailEffect = Fx.incendTrail;
                    ammoMultiplier = 10 * 4f;
                    despawnEffect = Fx.hitBulletColor;
                    lifeScaleRandMax = 1.08f;
                    lifeScaleRandMin = 0.95f;
                    buildingDamageMultiplier = 0f; //add
                }},
                Items.blastCompound, new ArtilleryBulletType(3 * 2f, 40, "shell"){{
                    hitEffect = new MultiEffect(Fx.blastExplosion, Fx.shockwave);
                    knockback = 0.8f;
                    lifetime = 80f;
                    width = 14f;
                    height = 16f;
                    collidesTiles = false;
                    ammoMultiplier = 10 * 4f;
                    splashDamageRadius = 50f * 0.75f;
                    splashDamage = 90f;

                    status = StatusEffects.blasted;
                    lifeScaleRandMax = 1.08f;
                    lifeScaleRandMin = 0.95f;

                    despawnEffect = Fx.hitBulletColor;
                    backColor = hitColor = trailColor = Pal.blastAmmoBack;
                    frontColor = Pal.blastAmmoFront;
                    buildingDamageMultiplier = 0f; //add
                }},
                Items.plastanium, new ArtilleryBulletType(3 * 3.4f, 40, "shell"){{
                    hitEffect = new MultiEffect(Fx.plasticExplosion, Fx.shockwave);
                    knockback = 1f;
                    lifetime = 80f;
                    width = 13f;
                    height = 15f;
                    collidesTiles = false;
                    splashDamageRadius = 40f * 0.75f;
                    splashDamage = 90f;
                    fragBullet = new BasicBulletType(8f, "bullet"){{
                        width = 10f;
                        height = 12f;
                        shrinkY = 1f;
                        lifetime = 15f;
                        backColor = Pal.plastaniumBack;
                        frontColor = Pal.plastaniumFront;
                        despawnEffect = Fx.none;
                        collidesAir = false;
                    }};
                    fragBullets = 15;
                    backColor = Pal.plastaniumBack;
                    frontColor = Pal.plastaniumFront;
                    lifeScaleRandMax = 1.08f;
                    lifeScaleRandMin = 0.95f;
                    buildingDamageMultiplier = 0f; //add
                }}
            );

            targetAir = false;
            size = 3;
            shoot.shots = 4;
            inaccuracy = 1f;//edit
            reload = 120f;
            ammoEjectBack = 5f;
            ammoUseEffect = Fx.casing3Double;
            ammoPerShot = 2;
            velocityRnd = 0.2f;

            recoil = 6f;
            shake = 2f;
            range = 3 * 290f;
            minRange = 50f;
            coolant = consumeCoolant(0.3f);

            scaledHealth = 130;
            depositCooldown = 2.0f;
            shootSound = Sounds.shootRipple;
            scaleLifetimeOffset = 1f / 10f;
            unitSort = UnitSorts.grouped;
        }};

        cyclone = new ItemTurret("cyclone"){{
            requirements(Category.turret, with(Items.copper, 200, Items.titanium, 125, Items.plastanium, 80));
            ammo(
                Items.metaglass, new FlakBulletType(3 * 4f, 6){{
                    ammoMultiplier = 10 * 2f;
                    shootEffect = Fx.shootSmall;
                    reloadMultiplier = 0.8f;
                    width = 6f;
                    height = 11f;
                    hitEffect = Fx.flakExplosion;
                    splashDamage = 45f;
                    splashDamageRadius = 25f;
                    fragBullet = new BasicBulletType(8f, "bullet"){{
                        width = 5f;
                        height = 12f;
                        shrinkY = 1f;
                        lifetime = 20f;
                        backColor = Pal.gray;
                        frontColor = Color.white;
                        despawnEffect = Fx.none;
                    }};
                    fragBullets = 4;
                    explodeRange = 20f;
                    collidesGround = true;

                    backColor = hitColor = trailColor = Pal.glassAmmoBack;
                    frontColor = Pal.glassAmmoFront;
                    despawnEffect = Fx.hitBulletColor;
                    buildingDamageMultiplier = 0f; //add
                }},
                Items.blastCompound, new FlakBulletType(3 * 4f, 8){{
                    shootEffect = Fx.shootBig;
                    ammoMultiplier = 10 * 5f;
                    splashDamage = 45f;
                    splashDamageRadius = 60f;
                    collidesGround = true;

                    status = StatusEffects.blasted;

                    backColor = hitColor = trailColor = Pal.blastAmmoBack;
                    frontColor = Pal.blastAmmoFront;
                    despawnEffect = Fx.hitBulletColor;
                    buildingDamageMultiplier = 0f; //add
                }},
                Items.plastanium, new FlakBulletType(3 * 4f, 8){{
                    ammoMultiplier = 10 * 4f;
                    splashDamageRadius = 40f;
                    splashDamage = 37.5f;
                    fragBullet = new BasicBulletType(8f, "bullet"){{
                        width = 10f;
                        height = 12f;
                        shrinkY = 1f;
                        lifetime = 15f;
                        backColor = Pal.plastaniumBack;
                        frontColor = Pal.plastaniumFront;
                        despawnEffect = Fx.none;
                    }};
                    fragBullets = 6;
                    hitEffect = Fx.plasticExplosion;
                    frontColor = Pal.plastaniumFront;
                    backColor = Pal.plastaniumBack;
                    shootEffect = Fx.shootBig;
                    collidesGround = true;
                    explodeRange = 20f;
                    despawnEffect = Fx.hitBulletColor;
                    buildingDamageMultiplier = 0f; //add
                }},
                Items.surgeAlloy, new FlakBulletType(3 * 4.5f, 13){{
                    ammoMultiplier = 10 * 5f;
                    splashDamage = 50f * 1.5f;
                    splashDamageRadius = 38f;
                    lightning = 2;
                    lightningLength = 7;
                    shootEffect = Fx.shootBig;
                    collidesGround = true;
                    explodeRange = 20f;

                    backColor = hitColor = trailColor = Pal.surgeAmmoBack;
                    frontColor = Pal.surgeAmmoFront;
                    despawnEffect = Fx.hitBulletColor;
                    buildingDamageMultiplier = 0f; //add
                }}
            );
            shootY = 10f;

            shoot = new ShootBarrel(){{
                barrels = new float[]{
                0f, 1f, 0f,
                3f, 0f, 0f,
                -3f, 0f, 0f,
                };
            }};

            recoils = 3;
            drawer = new DrawTurret(){{
                for(int i = 3; i > 0; i--){
                    int f = i;
                    parts.add(new RegionPart("-barrel-" + i){{
                        progress = PartProgress.recoil;
                        recoilIndex = f - 1;
                        under = true;
                        moveY = -2f;
                    }});
                }
            }};

            reload = 10f;
            range = 3 * 200f;
            size = 3;
            recoil = 1.5f;
            recoilTime = 10;
            rotateSpeed = 7f;
            inaccuracy = 1;//edit
            shootCone = 30f;
            shootSound = Sounds.shootCyclone;
            coolant = consumeCoolant(0.3f);

            scaledHealth = 145;
            depositCooldown = 2.0f;
            limitRange();
        }};

        foreshadow = new ItemTurret("foreshadow"){{
            float brange = range = 3 * 500f;

            requirements(Category.turret, with(Items.copper, 1000, Items.metaglass, 600, Items.surgeAlloy, 300, Items.plastanium, 200, Items.silicon, 600));
            ammo(
                Items.surgeAlloy, new RailBulletType(){{
                    shootEffect = Fx.instShoot;
                    hitEffect = Fx.instHit;
                    pierceEffect = Fx.railHit;
                    smokeEffect = Fx.smokeCloud;
                    pointEffect = Fx.instTrail;
                    despawnEffect = Fx.instBomb;
                    pointEffectSpace = 20f;
                    damage = 1350;
                    buildingDamageMultiplier = 0f;
                    pierceDamageFactor = 1f;
                    length = brange;
                    hitShake = 6f;
                    ammoMultiplier = 10 * 1f;
                }}
            );

            maxAmmo = 40;
            ammoPerShot = 5;
            rotateSpeed = 1.5f;
            reload = 200f;
            ammoUseEffect = Fx.casing3Double;
            recoil = 5f;
            cooldownTime = reload;
            shake = 4f;
            size = 4;
            shootCone = 2f;
            shootSound = Sounds.shootForeshadow;
            unitSort = UnitSorts.strongest;
            envEnabled |= Env.space;

            coolantMultiplier = 0.4f;
            liquidCapacity = 60f;
            scaledHealth = 150;

            coolant = consumeCoolant(1f);
            depositCooldown = 2.0f;
            consumePower(10f);
        }};

        spectre = new ItemTurret("spectre"){{
            requirements(Category.turret, with(Items.copper, 900, Items.graphite, 300, Items.surgeAlloy, 250, Items.plastanium, 175, Items.thorium, 250));
            ammo(
                Items.graphite, new BasicBulletType(12f, 50){{
                    lifetime = 65f;
                    hitSize = 4.8f;
                    width = 15f;
                    height = 21f;
                    shootEffect = Fx.shootBig;
                    ammoMultiplier = 10 * 4;
                    reloadMultiplier = 1.7f;
                    knockback = 0.3f;

                    hitEffect = despawnEffect = Fx.hitBulletColor;
                    hitColor = backColor = trailColor = Pal.graphiteAmmoBack;
                    frontColor = Pal.graphiteAmmoFront;
                    buildingDamageMultiplier = 0f; //add
                }},
                Items.thorium, new BasicBulletType(12f, 80){{
                    lifetime = 65f;
                    hitSize = 5;
                    width = 16f;
                    height = 23f;
                    shootEffect = Fx.shootBig;
                    pierceCap = 2;
                    pierceBuilding = true;
                    knockback = 0.7f;

                    backColor = hitColor = trailColor = Pal.thoriumAmmoBack;
                    frontColor = Pal.thoriumAmmoFront;
                    buildingDamageMultiplier = 0f; //add
                }},
                Items.pyratite, new BasicBulletType(12f, 70){{
                    lifetime = 65f;
                    hitSize = 5;
                    width = 16f;
                    height = 21f;
                    frontColor = Pal.lightishOrange;
                    backColor = Pal.lightOrange;
                    status = StatusEffects.burning;
                    hitEffect = new MultiEffect(Fx.hitBulletSmall, Fx.fireHit);
                    shootEffect = Fx.shootBig;
                    makeFire = true;
                    pierceCap = 2;
                    pierceBuilding = true;
                    knockback = 0.6f;
                    ammoMultiplier = 10 * 3;
                    splashDamage = 20f;
                    splashDamageRadius = 25f;
                    buildingDamageMultiplier = 0f; //add
                }}
            );
            reload = 7f;
            recoilTime = reload * 2f;
            coolantMultiplier = 0.5f;
            liquidCapacity = 120f;
            ammoUseEffect = Fx.casing3;
            range = 3 * 260f;
            inaccuracy = 1f;//edit
            recoil = 3f;
            shoot = new ShootAlternate(8f);
            shake = 2f;
            size = 4;
            shootCone = 24f;
            shootSound = Sounds.shootSpectre;

            scaledHealth = 160;
            coolant = consumeCoolant(1f);
            rotateSpeed = 4f;

            depositCooldown = 2.0f;
            limitRange();
        }};

        meltdown = new LaserTurret("meltdown"){{
            requirements(Category.turret, with(Items.copper, 1200, Items.lead, 350, Items.graphite, 300, Items.surgeAlloy, 325, Items.silicon, 325));
            shootEffect = Fx.shootBigSmoke2;
            shootCone = 40f;
            recoil = 4f;
            size = 4;
            shake = 2f;
            range = 3 * 195f;
            reload = 90f;
            firingMoveFract = 0.5f;
            shootDuration = 230f;
            shootSound = Sounds.shootMeltdown;
            loopSound = Sounds.beamMeltdown;
            loopSoundVolume = 2f;
            envEnabled |= Env.space;
            rotateSpeed = 1.5f;

            shootType = new ContinuousLaserBulletType(78){{
                length = 600f;
                hitEffect = Fx.hitMeltdown;
                hitColor = Pal.meltdownHit;
                status = StatusEffects.melting;
                drawSize = 420f;
                timescaleDamage = true;

                incendChance = 0.4f;
                incendSpread = 5f;
                incendAmount = 1;
                ammoMultiplier = 1f;
                buildingDamageMultiplier = 0f; //add
            }};

            scaledHealth = 200;
            liquidCapacity = 60f;
            coolant = consumeCoolant(0.5f);
            consumePower(17f);
        }};
}

{
        breach = new ItemTurret("breach"){{
            requirements(Category.turret, with(Items.beryllium, 150, Items.silicon, 150, Items.graphite, 125));

            Effect sfe = new MultiEffect(Fx.shootBigColor, Fx.colorSparkBig);

            ammo(
            Items.beryllium, new BasicBulletType(7.5f, 85){{
                width = 12f;
                hitSize = 7f;
                height = 20f;
                shootEffect = sfe;
                smokeEffect = Fx.shootBigSmoke;
                ammoMultiplier = 10 * 1;
                pierceCap = 2;
                pierce = true;
                pierceBuilding = true;
                hitColor = backColor = trailColor = Pal.berylShot;
                frontColor = Color.white;
                trailWidth = 2.1f;
                trailLength = 10;
                hitEffect = despawnEffect = Fx.hitBulletColor;
                buildingDamageMultiplier = 0f;
            }},
            Items.tungsten, new BasicBulletType(8f, 95){{
                width = 13f;
                height = 19f;
                hitSize = 7f;
                shootEffect = sfe;
                smokeEffect = Fx.shootBigSmoke;
                ammoMultiplier = 10 * 2;
                reloadMultiplier = 1f;
                pierceCap = 4;
                pierce = true;
                pierceBuilding = true;
                hitColor = backColor = trailColor = Pal.tungstenShot;
                frontColor = Color.white;
                trailWidth = 2.2f;
                trailLength = 11;
                hitEffect = despawnEffect = Fx.hitBulletColor;
                rangeChange = 40f;
                buildingDamageMultiplier = 0f;
            }},
            Items.carbide, new BasicBulletType(12f, 325f/0.75f){{
                width = 15f;
                height = 21f;
                hitSize = 7f;
                shootEffect = sfe;
                smokeEffect = Fx.shootBigSmoke;
                ammoMultiplier = 10 * 2;
                reloadMultiplier = 0.2f;
                hitColor = backColor = trailColor = Color.valueOf("ab8ec5");
                frontColor = Color.white;
                trailWidth = 2.2f;
                trailLength = 11;
                trailEffect = Fx.disperseTrail;
                trailInterval = 2f;
                hitEffect = despawnEffect = Fx.hitBulletColor;
                rangeChange = 7f*8f;
                buildingDamageMultiplier = 0f;
                trailRotation = true;
                shootSound = Sounds.shootBreachCarbide;

                fragBullets = 3;
                fragRandomSpread = 0f;
                fragSpread = 25f;
                fragVelocityMin = 1f;

                fragBullet = new BasicBulletType(8.1f, 227f){{
                    lifetime = 8f;
                    width = 11f;
                    height = 14f;
                    hitSize = 7f;
                    shootEffect = sfe;
                    ammoMultiplier = 10 * 1;
                    reloadMultiplier = 1f;
                    pierceCap = 2;
                    pierce = true;
                    pierceBuilding = true;
                    hitColor = backColor = trailColor = Color.valueOf("ab8ec5");
                    frontColor = Color.white;
                    trailWidth = 1.8f;
                    trailLength = 11;
                    hitEffect = despawnEffect = Fx.hitBulletColor;
                    buildingDamageMultiplier = 0f;
                }};
            }}
            );

            coolantMultiplier = 15f;
            shootSound = Sounds.shootBreach;

            targetUnderBlocks = false;
            shake = 1f;
            ammoPerShot = 2;
            drawer = new DrawTurret("reinforced-");
            shootY = -2;
            outlineColor = Pal.darkOutline;
            size = 3;
            envEnabled |= Env.space;
            reload = 40f;
            recoil = 2f;
            range = 3 * 190;
            shootCone = 3f;
            scaledHealth = 180;
            rotateSpeed = 1.5f;
            researchCostMultiplier = 0.05f;
            buildTime = 60f * 9f;

            coolant = consume(new ConsumeLiquid(Liquids.water, 15f / 60f));
            limitRange(12f);
        }};

        diffuse = new ItemTurret("diffuse"){{
            requirements(Category.turret, with(Items.beryllium, 150, Items.silicon, 200, Items.graphite, 200, Items.tungsten, 50));

            ammo(
            Items.graphite, new BasicBulletType(8f, 41){{
                knockback = 4f;
                width = 25f;
                hitSize = 7f;
                height = 20f;
                shootEffect = Fx.shootBigColor;
                smokeEffect = Fx.shootSmokeSquareSparse;
                ammoMultiplier = 10 * 1;
                hitColor = backColor = trailColor = Color.valueOf("ea8878");
                frontColor = Pal.redLight;
                trailWidth = 6f;
                trailLength = 3;
                hitEffect = despawnEffect = Fx.hitSquaresColor;
                buildingDamageMultiplier = 0f;
            }},
            Items.oxide, new BasicBulletType(8f, 90){{
                knockback = 3f;
                width = 25f;
                hitSize = 7f;
                height = 20f;
                shootEffect = Fx.shootBigColor;
                smokeEffect = Fx.shootSmokeSquareSparse;
                ammoMultiplier = 10 * 2;
                hitColor = backColor = trailColor = Color.valueOf("a0b380");
                frontColor = Color.valueOf("e4ffd6");
                trailWidth = 6f;
                trailLength = 3;
                hitEffect = despawnEffect = Fx.hitSquaresColor;
                buildingDamageMultiplier = 0f;
            }},
            Items.silicon, new BasicBulletType(8f, 35){{
                knockback = 3f;
                width = 25f;
                hitSize = 7f;
                height = 20f;
                homingPower = 0.045f;
                shootEffect = Fx.shootBigColor;
                smokeEffect = Fx.shootSmokeSquareSparse;
                ammoMultiplier = 10 * 1;
                hitColor = backColor = trailColor = Pal.siliconAmmoBack;
                frontColor = Color.valueOf("dae1ee");
                trailWidth = 6f;
                trailLength = 6;
                hitEffect = despawnEffect = Fx.hitSquaresColor;
                buildingDamageMultiplier = 0f;
            }}
            );

            shoot = new ShootSpread(15, 4f);

            coolantMultiplier = 15f;

            inaccuracy = 0.2f;
            velocityRnd = 0.17f;
            shake = 1f;
            ammoPerShot = 3;
            maxAmmo = 30;
            consumeAmmoOnce = true;
            targetUnderBlocks = false;

            shootSound = Sounds.shootDiffuse;

            drawer = new DrawTurret("reinforced-"){{
                parts.add(new RegionPart("-front"){{
                    progress = PartProgress.warmup;
                    moveRot = -10f;
                    mirror = true;
                    moves.add(new PartMove(PartProgress.recoil, 0f, -3f, -5f));
                    heatColor = Color.red;
                }});
            }};
            shootY = 5f;
            outlineColor = Pal.darkOutline;
            size = 3;
            envEnabled |= Env.space;
            reload = 30f;
            recoil = 2f;
            range = 3 * 125;
            shootCone = 40f;
            scaledHealth = 210;
            rotateSpeed = 3f;

            coolant = consume(new ConsumeLiquid(Liquids.water, 15f / 60f));
            limitRange(25f);
        }};

        sublimate = new ContinuousLiquidTurret("sublimate"){{
            requirements(Category.turret, with(Items.tungsten, 150, Items.silicon, 200, Items.oxide, 40, Items.beryllium, 400));

            drawer = new DrawTurret("reinforced-"){{

                Color heatc = Color.valueOf("fa2859");
                heatColor = heatc;

                parts.addAll(
                new RegionPart("-back"){{
                    progress = PartProgress.warmup;
                    mirror = true;
                    moveRot = 40f;
                    x = 22 / 4f;
                    y = -1f / 4f;
                    moveY = 6f / 4f;
                    under = true;
                    heatColor = heatc;
                }},
                new RegionPart("-front"){{
                    progress = PartProgress.warmup;
                    mirror = true;
                    moveRot = 40f;
                    x = 20 / 4f;
                    y = 17f / 4f;
                    moveX = 1f;
                    moveY = 1f;
                    under = true;
                    heatColor = heatc;
                }},
                new RegionPart("-nozzle"){{
                    progress = PartProgress.warmup;
                    mirror = true;
                    moveX = 8f / 4f;
                    heatColor = Color.valueOf("f03b0e");
                }});
            }};
            outlineColor = Pal.darkOutline;

            liquidCapacity = 50f;
            liquidConsumed = 18f / 60f;
            targetInterval = 5f;
            newTargetInterval = 30f;
            targetUnderBlocks = false;
            shootY = 8f;

            float r = range = 130f;

            loopSound = Sounds.shootSublimate;
            shootSound = Sounds.none;
            loopSoundVolume = 1f;

            ammo(
            Liquids.ozone, new ContinuousFlameBulletType(){{
                damage = 60f;
                length = r;
                ammoMultiplier = 10 * 1.2f;
                knockback = 1f;
                pierceCap = 2;
                buildingDamageMultiplier = 0f;
                timescaleDamage = true;

                colors = new Color[]{Color.valueOf("eb7abe").a(0.55f), Color.valueOf("e189f5").a(0.7f), Color.valueOf("907ef7").a(0.8f), Color.valueOf("91a4ff"), Color.white};
            }},
            Liquids.cyanogen, new ContinuousFlameBulletType(){{
                damage = 130f;
                rangeChange = 70f;
                length = r + rangeChange;
                knockback = 2f;
                pierceCap = 3;
                buildingDamageMultiplier = 0f;
                timescaleDamage = true;

                colors = new Color[]{Color.valueOf("465ab8").a(0.55f), Color.valueOf("66a6d2").a(0.7f), Color.valueOf("89e8b6").a(0.8f), Color.valueOf("cafcbe"), Color.white};
                flareColor = Color.valueOf("89e8b6");

                lightColor = hitColor = flareColor;
            }}
            );

            scaledHealth = 210;
            size = 3;

            researchCost = with(Items.tungsten, 400, Items.silicon, 400, Items.oxide, 80, Items.beryllium, 800);
        }};

        titan = new ItemTurret("titan"){{
            requirements(Category.turret, with(Items.tungsten, 250, Items.silicon, 300, Items.thorium, 400));

            ammo(
            Items.thorium, new ArtilleryBulletType(2.5f, 350, "shell"){{
                hitEffect = new MultiEffect(Fx.titanExplosion, Fx.titanSmoke);
                despawnEffect = Fx.none;
                knockback = 2f;
                lifetime = 140f;
                height = 19f;
                width = 17f;
                splashDamageRadius = 65f;
                splashDamage = 350f;
                scaledSplashDamage = true;
                backColor = hitColor = trailColor = Color.valueOf("ea8878").lerp(Pal.redLight, 0.5f);
                frontColor = Color.white;
                ammoMultiplier = 10 * 1f;
                hitSound = Sounds.explosionTitan;

                status = StatusEffects.blasted;

                trailLength = 32;
                trailWidth = 3.35f;
                trailSinScl = 2.5f;
                trailSinMag = 0.5f;
                trailEffect = Fx.none;
                despawnShake = 7f;

                shootEffect = Fx.shootTitan;
                smokeEffect = Fx.shootSmokeTitan;

                trailInterp = v -> Math.max(Mathf.slope(v), 0.8f);
                shrinkX = 0.2f;
                shrinkY = 0.1f;
                buildingDamageMultiplier = 0f;

                unitSort = UnitSorts.grouped;
            }},
            Items.carbide, new ArtilleryBulletType(3.25f, 700, "shell"){{
                hitEffect = new MultiEffect(Fx.titanExplosionSmall, Fx.titanSmokeSmall);
                despawnEffect = Fx.none;
                knockback = 3f;
                lifetime = 140f;
                height = 28f;
                width = 15f;
                splashDamageRadius = 36f;
                splashDamage = 750f;
                rangeChange = 10f*8f;
                reloadMultiplier = 0.8f;
                scaledSplashDamage = true;
                backColor = hitColor = trailColor = Color.valueOf("ab8ec5");
                frontColor = Color.white;
                ammoMultiplier = 10 * 1f;
                hitSound = Sounds.explosionTitan;

                status = StatusEffects.blasted;

                trailLength = 32;
                trailWidth = 3.35f;
                trailSinScl = 2.5f;
                trailSinMag = 0.5f;
                trailEffect = Fx.disperseTrail;
                trailInterval = 2f;
                despawnShake = 7f;

                shootEffect = Fx.shootTitan;
                smokeEffect = Fx.shootSmokeTitan;
                trailRotation = true;

                trailInterp = v -> Math.max(Mathf.slope(v), 0.8f);
                shrinkX = 0.2f;
                shrinkY = 0.1f;
                buildingDamageMultiplier = 0f;
                fragLifeMin = 1.5f;

                unitSort = UnitSorts.strongest;

                fragBullets = 12;
                    fragBullet = new ArtilleryBulletType(0.5f, 50, "shell"){{
                        hitEffect = new MultiEffect(Fx.titanExplosionFrag, Fx.titanLightSmall, new WaveEffect(){{
                            lifetime = 8f;
                            strokeFrom = 1f;
                            sizeTo = 8f;
                        }});

                        despawnEffect = Fx.hitBulletColor;
                        width = 8f;
                        height = 12f;
                        lifetime = 50f;
                        knockback = 0.5f;
                        splashDamageRadius = 22f;
                        splashDamage = 50f;
                        scaledSplashDamage = true;
                        pierceArmor = true;
                        backColor = frontColor = hitColor = Color.valueOf("ab8ec5");
                        frontColor = Color.white;
                        buildingDamageMultiplier = 0f;
                        shrinkY = 0.3f;
                    }};
            }},
            Items.oxide, new ArtilleryBulletType(2.5f, 300, "shell"){{
                hitEffect = new MultiEffect(Fx.titanExplosionLarge, Fx.titanSmokeLarge, Fx.smokeAoeCloud);
                despawnEffect = Fx.none;
                knockback = 2f;
                lifetime = 190f;
                height = 19f;
                width = 17f;
                reloadMultiplier = 0.7f;
                splashDamageRadius = 110f;
                rangeChange = 8f;
                splashDamage = 180f;
                scaledSplashDamage = true;
                hitColor = backColor = trailColor = Color.valueOf("a0b380");
                frontColor = Color.valueOf("e4ffd6");
                ammoMultiplier = 10 * 1f;
                hitSound = Sounds.explosionTitan;

                trailLength = 32;
                trailWidth = 3.35f;
                trailSinScl = 2.5f;
                trailSinMag = 0.5f;
                trailEffect = Fx.vapor;
                trailInterval = 3f;
                despawnShake = 7f;

                shootEffect = Fx.shootTitan;
                smokeEffect = Fx.shootSmokeTitan;

                trailInterp = v -> Math.max(Mathf.slope(v), 0.8f);
                shrinkX = 0.2f;
                shrinkY = 0.1f;
                buildingDamageMultiplier = 0f;
                status = StatusEffects.corroded;
                statusDuration = 60f * 8f;

                fragBullets = 1;
                fragBullet = new EmptyBulletType(){{
                    damage = 0f;
                    lifetime = 60f * 2.5f;
                    bulletInterval = 20f;
                    hitEffect = despawnEffect = Fx.none;
                    intervalBullet = new EmptyBulletType(){{
                        splashDamage = 15f;
                        collidesGround = true;
                        collidesAir = false;
                        collides = false;
                        hitEffect = despawnEffect = Fx.none;
                        pierce = true;
                        instantDisappear = true;
                        splashDamageRadius = 90f;
                        buildingDamageMultiplier = 0f;
                    }};
                }};

                unitSort = UnitSorts.grouped;
            }}
            );

            shootSound = Sounds.shootTank;
            ammoPerShot = 4;
            maxAmmo = ammoPerShot * 3;
            targetAir = false;
            shake = 4f;
            recoil = 1f;
            reload = 60f * 2.3f;
            shootY = 7f;
            rotateSpeed = 1.4f;
            minWarmup = 0.85f;

            newTargetInterval = 40f;
            shootWarmupSpeed = 0.07f;
            warmupMaintainTime = 120f;

            coolant = consume(new ConsumeLiquid(Liquids.water, 30f / 60f));
            coolantMultiplier = 3.75f;

            drawer = new DrawTurret("reinforced-"){{
                parts.addAll(
                new RegionPart("-barrel"){{
                    progress = PartProgress.recoil.curve(Interp.pow2In);
                    moveY = -5f * 4f / 3f;
                    heatColor = Color.valueOf("f03b0e");
                    mirror = false;
                }},
                new RegionPart("-side"){{
                    heatProgress = PartProgress.warmup;
                    progress = PartProgress.warmup;
                    mirror = true;
                    moveX = 2f * 4f / 3f;
                    moveY = -0.5f;
                    moveRot = -40f;
                    under = true;
                    heatColor = Color.red.cpy();
                }});
            }};

            shootWarmupSpeed = 0.08f;

            outlineColor = Pal.darkOutline;

            consumeLiquid(Liquids.hydrogen, 5f / 60f);

            scaledHealth = 250;
            range = 3 * 390f;
            size = 4;
        }};

        disperse = new ItemTurret("disperse"){{
            requirements(Category.turret, with(Items.thorium, 50, Items.oxide, 50, Items.silicon, 200, Items.beryllium, 350));

            ammo(
            Items.tungsten, new BasicBulletType(){{
                damage = 65;
                speed = 8.5f;
                width = height = 16;
                shrinkY = 0.3f;
                backSprite = "large-bomb-back";
                sprite = "mine-bullet";
                velocityRnd = 0.11f;
                collidesGround = false;
                collidesTiles = false;
                shootEffect = Fx.shootBig2;
                smokeEffect = Fx.shootSmokeDisperse;
                frontColor = Color.white;
                backColor = trailColor = hitColor = Color.sky;
                trailChance = 0.44f;
                ammoMultiplier = 10 * 3f;

                lifetime = 34f;
                rotationOffset = 90f;
                trailRotation = true;
                trailEffect = Fx.disperseTrail;

                hitEffect = despawnEffect = Fx.hitBulletColor;
            }},
            Items.thorium, new BasicBulletType(){{
                damage = 90;
                reloadMultiplier = 0.85f;
                rangeChange = -120f;
                speed = 9.5f;
                width = height = 16;
                pierceCap = 2;
                shrinkY = 0.3f;
                backSprite = "large-bomb-back";
                sprite = "mine-bullet";
                velocityRnd = 0.5f;
                collidesGround = false;
                collidesTiles = false;
                shootEffect = Fx.shootBig2;
                smokeEffect = Fx.shootSmokeDisperse;
                frontColor = Color.white;
                backColor = trailColor = hitColor = Color.valueOf("e89dbd");
                trailChance = 0.44f;
                ammoMultiplier = 10 * 1f;

                lifetime = 34f;
                extraRangeMargin = 32f;
                rotationOffset = 90f;
                trailRotation = true;
                trailEffect = Fx.disperseTrail;

                hitEffect = despawnEffect = Fx.hitBulletColor;
            }},
            Items.silicon, new BasicBulletType(){{
                damage = 37;
                homingPower = 0.045f;
                speed = 9f;
                width = height = 16;
                shrinkY = 0.3f;
                backSprite = "large-bomb-back";
                sprite = "mine-bullet";
                velocityRnd = 0.11f;
                collidesGround = false;
                collidesTiles = false;
                shootEffect = Fx.shootBig2;
                smokeEffect = Fx.shootSmokeDisperse;
                frontColor = Color.valueOf("dae1ee");
                backColor = trailColor = hitColor = Pal.siliconAmmoBack;
                ammoMultiplier = 10 * 4f;

                lifetime = 34f;
                rotationOffset = 90f;
                trailLength = 7;
                //for chasing targets
                extraRangeMargin = 32f;

                hitEffect = despawnEffect = Fx.hitBulletColor;
            }},

            Items.surgeAlloy, new BasicBulletType(){{
                reloadMultiplier = 0.75f;
                damage = 65;
                rangeChange = 8f * 3f;
                lightning = 3;
                lightningLength = 4;
                lightningDamage = 18f;
                lightningLengthRand = 3;
                speed = 6f;
                width = height = 16;
                shrinkY = 0.3f;
                backSprite = "large-bomb-back";
                sprite = "mine-bullet";
                velocityRnd = 0.11f;
                collidesGround = false;
                collidesTiles = false;
                shootEffect = Fx.shootBig2;
                smokeEffect = Fx.shootSmokeDisperse;
                frontColor = Color.white;
                backColor = trailColor = hitColor = Pal.surge;
                trailChance = 0.44f;
                ammoMultiplier = 10 * 3f;

                lifetime = 34f;
                rotationOffset = 90f;
                trailRotation = true;
                trailEffect = Fx.disperseTrail;

                hitEffect = despawnEffect = Fx.hitBulletColor;

                bulletInterval = 4f;

                intervalBullet = new BulletType(){{
                    collidesGround = false;
                    collidesTiles = false;
                    lightningLengthRand = 4;
                    lightningLength = 2;
                    lightningCone = 30f;
                    lightningDamage = 20f;
                    lightning = 1;
                    hittable = collides = false;
                    instantDisappear = true;
                    hitEffect = despawnEffect = Fx.none;
                }};
            }}
            );

            reload = 9f;
            shootY = 15f;
            rotateSpeed = 5f;
            shootCone = 30f;
            consumeAmmoOnce = true;
            shootSound = Sounds.shootDisperse;

            drawer = new DrawTurret("reinforced-"){{
                parts.add(new RegionPart("-side"){{
                    mirror = true;
                    under = true;
                    moveX = 1.75f;
                    moveY = -0.5f;
                }},
                new RegionPart("-mid"){{
                    under = true;
                    moveY = -1.5f;
                    progress = PartProgress.recoil;
                    heatProgress = PartProgress.recoil.add(0.25f).min(PartProgress.warmup);
                    heatColor = Color.sky.cpy().a(0.9f);
                }},
                new RegionPart("-blade"){{
                    heatProgress = PartProgress.warmup;
                    heatColor = Color.sky.cpy().a(0.9f);
                    mirror = true;
                    under = true;
                    moveY = 1f;
                    moveX = 1.5f;
                    moveRot = 8;
                }});
            }};

            shoot = new ShootAlternate(){{
                spread = 4.7f;
                shots = 4;
                barrels = 4;
            }};

            targetGround = false;
            inaccuracy = 8f;

            shootWarmupSpeed = 0.08f;

            outlineColor = Pal.darkOutline;

            scaledHealth = 280;
            range = 3 * 310f;
            size = 4;

            coolant = consume(new ConsumeLiquid(Liquids.water, 20f / 60f));
            coolantMultiplier = 6.25f;

            limitRange(16f);
        }};

        afflict = new PowerTurret("afflict"){{
            requirements(Category.turret, with(Items.surgeAlloy, 100, Items.silicon, 200, Items.graphite, 250, Items.oxide, 40));
            buildCostMultiplier = 1f;

            shootType = new BasicBulletType(){{
                shootEffect = new MultiEffect(Fx.shootTitan, new WaveEffect(){{
                    colorTo = Pal.surge;
                    sizeTo = 26f;
                    lifetime = 14f;
                    strokeFrom = 4f;
                }});
                smokeEffect = Fx.shootSmokeTitan;
                hitColor = Pal.surge;

                sprite = "large-orb";
                trailEffect = Fx.missileTrail;
                trailInterval = 3f;
                trailParam = 4f;
                pierceCap = 2;
                buildingDamageMultiplier = 0f;
                fragOnHit = false;
                speed = 5f;
                damage = 180f;
                lifetime = 80f;
                width = height = 16f;
                backColor = Pal.surge;
                frontColor = Color.white;
                shrinkX = shrinkY = 0f;
                trailColor = Pal.surge;
                trailLength = 12;
                trailWidth = 2.2f;
                despawnEffect = hitEffect = new ExplosionEffect(){{
                    waveColor = Pal.surge;
                    smokeColor = Color.gray;
                    sparkColor = Pal.surge;
                    waveStroke = 4f;
                    waveRad = 40f;
                }};

                despawnSound = Sounds.explosionAfflict;
                shootSound = Sounds.shootAfflict;

                fragBullet = intervalBullet = new BasicBulletType(3f, 35){{
                    width = 9f;
                    hitSize = 5f;
                    height = 15f;
                    pierceCap = 3;
                    lifetime = 28f;
                    pierceBuilding = true;
                    hitColor = backColor = trailColor = Pal.surge;
                    frontColor = Color.white;
                    trailWidth = 2.1f;
                    trailLength = 5;
                    hitEffect = despawnEffect = new WaveEffect(){{
                        colorFrom = colorTo = Pal.surge;
                        sizeTo = 4f;
                        strokeFrom = 4f;
                        lifetime = 10f;
                    }};
                    buildingDamageMultiplier = 0f;
                    homingPower = 0.1f;
                }};

                bulletInterval = 3f;
                intervalRandomSpread = 20f;
                intervalBullets = 2;
                intervalAngle = 180f;
                intervalSpread = 300f;

                fragBullets = 20;
                fragVelocityMin = 0.5f;
                fragVelocityMax = 1.2f;
                fragLifeMin = 0.5f;
            }};

            drawer = new DrawTurret("reinforced-"){{
                parts.add(new RegionPart("-blade"){{
                    progress = PartProgress.recoil;
                    heatColor = Color.valueOf("ff6214");
                    mirror = true;
                    under = true;
                    moveX = 2f;
                    moveY = -1f;
                    moveRot = -7f;
                }},
                new RegionPart("-blade-glow"){{
                    progress = PartProgress.recoil;
                    heatProgress = PartProgress.warmup;
                    heatColor = Color.valueOf("ff6214");
                    drawRegion = false;
                    mirror = true;
                    under = true;
                    moveX = 2f;
                    moveY = -1f;
                    moveRot = -7f;
                }});
            }};

            consumePower(5f);
            heatRequirement = 20f;
            maxHeatEfficiency = 1f;

            newTargetInterval = 40f;

            inaccuracy = 1f;
            shake = 2f;
            shootY = 4;
            outlineColor = Pal.darkOutline;
            size = 4;
            envEnabled |= Env.space;
            reload = 50f;
            cooldownTime = 100f;
            recoil = 3f;
            range = 3 * 368;
            shootCone = 20f;
            scaledHealth = 220;
            rotateSpeed = 1.5f;
            researchCostMultiplier = 0.04f;
            buildCostMultiplier = 1.5f;

            limitRange(-55f);
        }};

        lustre = new ContinuousTurret("lustre"){{
            requirements(Category.turret, with(Items.silicon, 250, Items.graphite, 200, Items.oxide, 50, Items.carbide, 90));

            shootType = new PointLaserBulletType(){{
                damage = 210f;
                buildingDamageMultiplier = 0f;
                hitColor = Color.valueOf("fda981");
            }};

            drawer = new DrawTurret("reinforced-"){{
                var heatp = PartProgress.warmup.blend(p -> Mathf.absin(2f, 1f) * p.warmup, 0.2f);

                parts.add(new RegionPart("-blade"){{
                    progress = PartProgress.warmup;
                    heatProgress = PartProgress.warmup;
                    heatColor = Color.valueOf("ff6214");
                    mirror = true;
                    under = true;
                    moveX = 2f;
                    moveRot = -7f;
                    moves.add(new PartMove(PartProgress.warmup, 0f, -2f, 3f));
                }},
                new RegionPart("-inner"){{
                    heatProgress = heatp;
                    progress = PartProgress.warmup;
                    heatColor = Color.valueOf("ff6214");
                    mirror = true;
                    under = false;
                    moveX = 2f;
                    moveY = -8f;
                }},
                new RegionPart("-mid"){{
                    heatProgress = heatp;
                    progress = PartProgress.warmup;
                    heatColor = Color.valueOf("ff6214");
                    moveY = -8f;
                    mirror = false;
                    under = true;
                }});
            }};

            scaleDamageEfficiency = true;
            shootSound = Sounds.none;
            loopSoundVolume = 1f;
            loopSound = Sounds.beamLustre;

            shootWarmupSpeed = 0.08f;
            shootCone = 360f;

            aimChangeSpeed = 0.9f;
            rotateSpeed = 0.9f;

            shootY = 0.5f;
            outlineColor = Pal.darkOutline;
            size = 4;
            envEnabled |= Env.space;
            range = 3 * 250f;
            scaledHealth = 210;

            unitSort = UnitSorts.strongest;

            consumeLiquid(Liquids.nitrogen, 6f / 60f);
            consumePower(200f / 60f);
        }};

        scathe = new ItemTurret("scathe"){{
            requirements(Category.turret, with(Items.silicon, 450, Items.graphite, 400, Items.tungsten, 500, Items.oxide, 100, Items.carbide, 200));

            predictTarget = false;

            ammo(
            Items.carbide, new BulletType(0f, 0f){{
                shootEffect = Fx.shootBig;
                smokeEffect = Fx.shootSmokeMissileColor;
                hitColor = Pal.redLight;
                ammoMultiplier = 10 * 1f;

                spawnUnit = new MissileUnitType("scathe-missile"){{
                    speed = 4.6f;
                    maxRange = 6f;
                    lifetime = 60f * 5.5f;
                    hitSize = 10f;
                    outlineColor = Pal.darkOutline;
                    engineColor = trailColor = Pal.redLight;
                    engineLayer = Layer.effect;
                    engineSize = 3.1f;
                    engineOffset = 10f;
                    rotateSpeed = 0.25f;
                    trailLength = 18;
                    missileAccelTime = 50f;
                    lowAltitude = true;
                    loopSound = Sounds.loopMissileTrail;
                    loopSoundVolume = 0.6f;
                    deathSound = Sounds.explosionMissile;
                    targetAir = false;
                    targetUnderBlocks = false;

                    fogRadius = 6f;

                    health = 240;

                    weapons.add(new Weapon(){{
                        shootCone = 360f;
                        mirror = false;
                        reload = 1f;
                        deathExplosionEffect = Fx.massiveExplosion;
                        shootOnDeath = true;
                        shake = 10f;
                        bullet = new ExplosionBulletType(1000f, 65f){{
                            hitColor = Pal.redLight;
                            shootEffect = new MultiEffect(Fx.massiveExplosion, Fx.scatheExplosion, Fx.scatheLight, new WaveEffect(){{
                                lifetime = 10f;
                                strokeFrom = 4f;
                                sizeTo = 130f;
                            }});

                            collidesAir = false;
                            buildingDamageMultiplier = 0f;

                            ammoMultiplier = 10 * 1f;
                            fragLifeMin = 0.1f;
                            fragBullets = 7;
                            fragBullet = new ArtilleryBulletType(3.4f, 32){{
                                buildingDamageMultiplier = 0f;
                                drag = 0.02f;
                                hitEffect = Fx.massiveExplosion;
                                despawnEffect = Fx.scatheSlash;
                                knockback = 0.8f;
                                lifetime = 23f;
                                width = height = 18f;
                                collidesTiles = false;
                                splashDamageRadius = 40f;
                                splashDamage = 100f;
                                backColor = trailColor = hitColor = Pal.redLight;
                                frontColor = Color.white;
                                smokeEffect = Fx.shootBigSmoke2;
                                despawnShake = 7f;
                                lightRadius = 30f;
                                lightColor = Pal.redLight;
                                lightOpacity = 0.5f;

                                trailLength = 20;
                                trailWidth = 3.5f;
                                trailEffect = Fx.none;
                            }};
                        }};
                    }});

                    abilities.add(new MoveEffectAbility(){{
                        effect = Fx.missileTrailSmoke;
                        rotation = 180f;
                        y = -9f;
                        color = Color.grays(0.6f).lerp(Pal.redLight, 0.5f).a(0.4f);
                        interval = 7f;
                    }});
                }};
            }},

            Items.phaseFabric, new BulletType(0f, 0f){{
                shootEffect = Fx.shootBig;
                smokeEffect = Fx.shootSmokeMissileColor;
                hitColor = Color.valueOf("ffd37f");
                ammoMultiplier = 10 * 5f;
                reloadMultiplier = 0.8f;

                spawnUnit = new MissileUnitType("scathe-missile-phase"){{
                    speed = 2.5f;
                    maxRange = 6f;
                    lifetime = 60f * 9.77f;
                    hitSize = 10f;
                    outlineColor = Pal.darkOutline;
                    engineColor = trailColor = Color.valueOf("ffd37f");
                    engineLayer = Layer.effect;
                    engineSize = 3.1f;
                    engineOffset = 10f;
                    rotateSpeed = 0.2f;
                    trailLength = 18;
                    missileAccelTime = 50f;
                    lowAltitude = true;
                    loopSound = Sounds.loopMissileTrail;
                    loopSoundVolume = 0.6f;
                    deathSound = Sounds.explosionMissile;
                    targetAir = false;
                    targetUnderBlocks = false;

                    parts.add(new ShapePart(){{
                        progress = PartProgress.constant(1f);
                        color = Pal.accent;
                        sides = 6;
                        radius = 3f;
                        rotateSpeed = 3f;
                        hollow = true;
                        layer = Layer.effect;
                        y = 1.8f;
                    }});

                    fogRadius = 6f;

                    health = 500;

                    weapons.add(new Weapon(){{
                        shootCone = 360f;
                        mirror = false;
                        reload = 1f;
                        deathExplosionEffect = Fx.massiveExplosion;
                        shootOnDeath = true;
                        shake = 10f;
                        bullet = new ExplosionBulletType(320f, 120f){{
                            reloadMultiplier = 0.8f;
                            ammoMultiplier = 10 * 5f;

                            hitColor = engineColor;
                            shootEffect = new MultiEffect(Fx.massiveExplosion, Fx.scatheExplosion, Fx.scatheLight, new WaveEffect(){{
                                lifetime = 10f;
                                strokeFrom = 4f;
                                sizeTo = 130f;
                            }});

                            collidesAir = false;
                            buildingDamageMultiplier = 0f;

                            fragLifeMin = 0.1f;
                            fragBullets = 7;
                            fragBullet = new ArtilleryBulletType(3.4f, 32){{
                                buildingDamageMultiplier = 0f;
                                drag = 0.02f;
                                hitEffect = Fx.massiveExplosion;
                                despawnEffect = Fx.scatheSlash;
                                knockback = 0.8f;
                                lifetime = 23f;
                                width = height = 18f;
                                collidesTiles = false;
                                splashDamageRadius = 56f;
                                splashDamage = 120f;
                                backColor = trailColor = hitColor = engineColor;
                                frontColor = Color.white;
                                smokeEffect = Fx.shootBigSmoke2;
                                despawnShake = 7f;
                                lightRadius = 30f;
                                lightColor = engineColor;
                                lightOpacity = 0.5f;

                                trailLength = 20;
                                trailWidth = 3.5f;
                                trailEffect = Fx.none;
                            }};
                        }};
                    }});

                    abilities.add(new MoveEffectAbility(){{
                        effect = Fx.missileTrailSmoke;
                        rotation = 180f;
                        y = -9f;
                        color = Color.grays(0.6f).lerp(Pal.redLight, 0.5f).a(0.4f);
                        interval = 15f;
                    }});

                    abilities.add(new ForceFieldAbility(120f, 0f, 3000f, 999999999f));

                }};
            }},

            Items.surgeAlloy, new BulletType(0f, 0f){{
                shootEffect = Fx.shootBig;
                smokeEffect = Fx.shootSmokeMissileColor;
                hitColor = Color.valueOf("f7e97e");

                ammoMultiplier = 10 * 1f;
                reloadMultiplier = 0.9f;

                spawnUnit = new MissileUnitType("scathe-missile-surge"){{
                    speed = 4.4f;
                    maxRange = 6f;
                    lifetime = 60f * 1.4f;
                    hitSize = 10f;
                    outlineColor = Pal.darkOutline;
                    engineColor = trailColor = Color.valueOf("f7e97e");
                    engineLayer = Layer.effect;
                    engineSize = 3.1f;
                    engineOffset = 10f;
                    rotateSpeed = 0.25f;
                    trailLength = 18;
                    missileAccelTime = 30f;
                    lowAltitude = true;
                    loopSound = Sounds.loopMissileTrail;
                    loopSoundVolume = 0.6f;
                    deathSound = Sounds.explosionMissile;
                    targetAir = false;
                    targetUnderBlocks = false;

                    fogRadius = 6f;

                    health = 300;

                    weapons.add(new Weapon(){{
                        shootCone = 360f;
                        rotate = true;
                        rotationLimit = rotateSpeed = 0f;
                        reload = 1f;
                        deathExplosionEffect = Fx.massiveExplosion;
                        shootOnDeath = true;
                        shake = 10f;
                        bullet = new ExplosionBulletType(1800f, 40f){{
                            //mirror stats
                            ammoMultiplier = 10 * 1f;
                            reloadMultiplier = 0.9f;
                            lightning = 10;
                            lightningDamage = 45f;
                            lightningLength = 12;

                            hitColor = engineColor;
                            shootEffect = new MultiEffect(Fx.massiveExplosion, Fx.scatheExplosionSmall);

                            collidesAir = false;
                            buildingDamageMultiplier = 0f;

                            fragLifeMin = 0.1f;
                            fragBullets = 5;
                            fragRandomSpread = 0f;
                            fragSpread = 20f;
                            fragBullet = new BulletType(){{
                                shootEffect = Fx.shootBig;
                                smokeEffect = Fx.shootSmokeMissileColor;
                                hitColor = engineColor;
                                ammoMultiplier = 10 * 1f;

                                spawnUnit = new MissileUnitType("scathe-missile-surge-split"){{
                                    speed = 4.8f;
                                    maxRange = 6f;
                                    lifetime = 60f * 3.7f;
                                    outlineColor = Pal.darkOutline;
                                    engineColor = trailColor = Color.valueOf("f7e97e");
                                    engineLayer = Layer.effect;
                                    engineSize = 2.2f;
                                    engineOffset = 8f;
                                    rotateSpeed = 1.4f;
                                    trailLength = 12;
                                    lowAltitude = true;
                                    loopSound = Sounds.loopMissileTrail;
                                    loopSoundVolume = 0.6f;
                                    deathSound = Sounds.explosionMissile;
                                    targetAir = false;
                                    targetUnderBlocks = false;

                                    fogRadius = 6f;

                                    health = 50;

                                    weapons.add(new Weapon(){{
                                        shootCone = 360f;
                                        mirror = false;
                                        reload = 1f;
                                        deathExplosionEffect = Fx.massiveExplosion;
                                        shootOnDeath = true;
                                        shake = 10f;
                                        bullet = new ExplosionBulletType(180f, 35f){{
                                            lightning = 4;
                                            lightningDamage = 25f;
                                            lightningLength = 6;

                                            hitColor = engineColor;
                                            shootEffect = new MultiEffect(Fx.massiveExplosion, Fx.scatheExplosionSmall, Fx.scatheLightSmall, new WaveEffect(){{
                                                lifetime = 10f;
                                                strokeFrom = 4f;
                                                sizeTo = 100f;
                                            }});

                                            collidesAir = false;
                                            buildingDamageMultiplier = 0f;
                                        }};
                                    }});

                                    abilities.add(new MoveEffectAbility(){{
                                        effect = Fx.missileTrailSmokeSmall;
                                        rotation = 180f;
                                        y = -9f;
                                        color = Color.grays(0.6f).lerp(Color.valueOf("f7e97e"), 0.5f).a(0.4f);
                                        interval = 5f;
                                    }});
                                }};
                            }};
                        }};
                    }});

                    abilities.add(new MoveEffectAbility(){{
                        effect = Fx.missileTrailSmoke;
                        rotation = 180f;
                        y = -9f;
                        color = Color.grays(0.6f).lerp(Color.valueOf("f7e97e"), 0.5f).a(0.4f);
                        interval = 7f;
                    }});
                }};
            }}
            );

            drawer = new DrawTurret("reinforced-"){{
                parts.add(new RegionPart("-blade"){{
                    progress = PartProgress.warmup;
                    heatProgress = PartProgress.warmup;
                    heatColor = Color.red;
                    moveRot = -22f;
                    moveX = 0f;
                    moveY = -5f;
                    mirror = true;
                    children.add(new RegionPart("-side"){{
                        progress = PartProgress.warmup.delay(0.6f);
                        heatProgress = PartProgress.recoil;
                        heatColor = Color.red;
                        mirror = true;
                        under = false;
                        moveY = -4f;
                        moveX = 1f;

                        moves.add(new PartMove(PartProgress.recoil, 1f, 6f, -40f));
                    }});
                }},
                new RegionPart("-mid"){{
                    progress = PartProgress.recoil;
                    heatProgress = PartProgress.warmup.add(-0.2f).add(p -> Mathf.sin(9f, 0.2f) * p.warmup);
                    mirror = false;
                    under = true;
                    moveY = -5f;
                }}, new RegionPart("-missile"){{
                    progress = PartProgress.reload.curve(Interp.pow2In);

                    colorTo = new Color(1f, 1f, 1f, 0f);
                    color = Color.white;
                    mixColorTo = Pal.accent;
                    mixColor = new Color(1f, 1f, 1f, 0f);
                    outline = false;
                    under = true;

                    layerOffset = -0.01f;

                    moves.add(new PartMove(PartProgress.warmup.inv(), 0f, -4f, 0f));
                }});
                setAmmoParts(
                    Items.carbide, Seq.with(new RegionPart("-missile"){{
                        progress = PartProgress.reload.curve(Interp.pow2In);

                        colorTo = new Color(1f, 1f, 1f, 0f);
                        color = Color.white;
                        mixColorTo = Pal.accent;
                        mixColor = new Color(1f, 1f, 1f, 0f);
                        outline = false;
                        under = true;
                        layerOffset = -0.01f;

                        moves.add(new PartMove(PartProgress.warmup.inv(), 0f, -4f, 0f));
                    }}),
                    Items.phaseFabric, Seq.with(new RegionPart("-missile-phase"){{
                        progress = PartProgress.reload.curve(Interp.pow2In);

                        colorTo = new Color(1f, 1f, 1f, 0f);
                        color = Color.white;
                        mixColorTo = Pal.accent;
                        mixColor = new Color(1f, 1f, 1f, 0f);
                        outline = false;
                        under = true;
                        layerOffset = -0.01f;

                        moves.add(new PartMove(PartProgress.warmup.inv(), 0f, -4f, 0f));
                    }}),
                    Items.surgeAlloy, Seq.with(new RegionPart("-missile-surge"){{
                        progress = PartProgress.reload.curve(Interp.pow2In);

                        colorTo = new Color(1f, 1f, 1f, 0f);
                        color = Color.white;
                        mixColorTo = Pal.accent;
                        mixColor = new Color(1f, 1f, 1f, 0f);
                        outline = false;
                        under = true;
                        layerOffset = -0.01f;

                        moves.add(new PartMove(PartProgress.warmup.inv(), 0f, -4f, 0f));
                    }})
                );
            }};

            recoil = 0.5f;

            fogRadiusMultiplier = 0.4f;
            coolantMultiplier = 15f;
            shootSound = Sounds.shootScathe;

            minWarmup = 0.94f;
            newTargetInterval = 40f;
            unitSort = UnitSorts.strongest;
            shootWarmupSpeed = 0.03f;
            targetAir = false;
            targetUnderBlocks = false;

            shake = 6f;
            ammoPerShot = 15;
            maxAmmo = 45;
            shootY = -1;
            outlineColor = Pal.darkOutline;
            size = 4;
            envEnabled |= Env.space;
            reload = 600f;
            range = 3 * 1350;
            shootCone = 1f;
            scaledHealth = 220;
            rotateSpeed = 0.9f;

            coolant = consume(new ConsumeLiquid(Liquids.water, 15f / 60f));
            limitRange();
        }};

        smite = new ItemTurret("smite"){{
            requirements(Category.turret, with(Items.oxide, 200, Items.surgeAlloy, 400, Items.silicon, 800, Items.carbide, 500, Items.phaseFabric, 300));

            ammo(
            Items.surgeAlloy, new BasicBulletType(7f, 250){{
                sprite = "large-orb";
                width = 17f;
                height = 21f;
                hitSize = 8f;

                shootEffect = new MultiEffect(Fx.shootTitan, Fx.colorSparkBig, new WaveEffect(){{
                    colorFrom = colorTo = Pal.accent;
                    lifetime = 12f;
                    sizeTo = 20f;
                    strokeFrom = 3f;
                    strokeTo = 0.3f;
                }});
                smokeEffect = Fx.shootSmokeSmite;
                ammoMultiplier = 10 * 1;
                pierceCap = 4;
                pierce = true;
                pierceBuilding = true;
                hitColor = backColor = trailColor = Pal.accent;
                frontColor = Color.white;
                trailWidth = 2.8f;
                trailLength = 9;
                hitEffect = Fx.hitBulletColor;
                buildingDamageMultiplier = 0f;

                despawnEffect = new MultiEffect(Fx.hitBulletColor, new WaveEffect(){{
                    sizeTo = 30f;
                    colorFrom = colorTo = Pal.accent;
                    lifetime = 12f;
                }});

                trailRotation = true;
                trailEffect = Fx.disperseTrail;
                trailInterval = 3f;

                intervalBullet = new LightningBulletType(){{
                    damage = 30;
                    collidesAir = false;
                    ammoMultiplier = 10 * 1f;
                    lightningColor = Pal.accent;
                    lightningLength = 5;
                    lightningLengthRand = 10;

                    //for visual stats only.
                    buildingDamageMultiplier = 0f;

                    lightningType = new BulletType(0.0001f, 0f){{
                        lifetime = Fx.lightning.lifetime;
                        hitEffect = Fx.hitLancer;
                        despawnEffect = Fx.none;
                        status = StatusEffects.shocked;
                        hittable = false;
                        lightColor = Color.white;
                        buildingDamageMultiplier = 0f;
                    }};
                }};

                bulletInterval = 3f;
            }}
            );

            shoot = new ShootMulti(new ShootAlternate(){{
                spread = 3.3f * 1.9f;
                shots = barrels = 5;
            }}, new ShootHelix(){{
                scl = 4f;
                mag = 3f;
            }});

            shootSound = Sounds.shootSmite;
            minWarmup = 0.99f;
            coolantMultiplier = 15f;

            var haloProgress = PartProgress.warmup.delay(0.5f);
            float haloY = -15f, haloRotSpeed = 1f;

            shake = 2f;
            ammoPerShot = 2;
            drawer = new DrawTurret("reinforced-"){{
                parts.addAll(

                new RegionPart("-mid"){{
                    heatProgress = PartProgress.heat.blend(PartProgress.warmup, 0.5f);
                    mirror = false;
                }},
                new RegionPart("-blade"){{
                    progress = PartProgress.warmup;
                    heatProgress = PartProgress.warmup;
                    mirror = true;
                    moveX = 5.5f;
                    moves.add(new PartMove(PartProgress.recoil, 0f, -3f, 0f));
                }},
                new RegionPart("-front"){{
                    progress = PartProgress.warmup;
                    heatProgress = PartProgress.recoil;
                    mirror = true;
                    under = true;
                    moveY = 4f;
                    moveX = 6.5f;
                    moves.add(new PartMove(PartProgress.recoil, 0f, -5.5f, 0f));
                }},
                new RegionPart("-back"){{
                    progress = PartProgress.warmup;
                    heatProgress = PartProgress.warmup;
                    mirror = true;
                    under = true;
                    moveX = 5.5f;
                }},
                new ShapePart(){{
                    progress = PartProgress.warmup.delay(0.2f);
                    color = Pal.accent;
                    circle = true;
                    hollow = true;
                    stroke = 0f;
                    strokeTo = 2f;
                    radius = 10f;
                    layer = Layer.effect;
                    y = haloY;
                    rotateSpeed = haloRotSpeed;
                }},
                new ShapePart(){{
                    progress = PartProgress.warmup.delay(0.2f);
                    color = Pal.accent;
                    circle = true;
                    hollow = true;
                    stroke = 0f;
                    strokeTo = 1.6f;
                    radius = 4f;
                    layer = Layer.effect;
                    y = haloY;
                    rotateSpeed = haloRotSpeed;
                }},
                new HaloPart(){{
                    progress = haloProgress;
                    color = Pal.accent;
                    layer = Layer.effect;
                    y = haloY;

                    haloRotation = 90f;
                    shapes = 2;
                    triLength = 0f;
                    triLengthTo = 20f;
                    haloRadius = 16f;
                    tri = true;
                    radius = 4f;
                }},
                new HaloPart(){{
                    progress = haloProgress;
                    color = Pal.accent;
                    layer = Layer.effect;
                    y = haloY;

                    haloRotation = 90f;
                    shapes = 2;
                    triLength = 0f;
                    triLengthTo = 5f;
                    haloRadius = 16f;
                    tri = true;
                    radius = 4f;
                    shapeRotation = 180f;
                }},
                new HaloPart(){{
                    progress = haloProgress;
                    color = Pal.accent;
                    layer = Layer.effect;
                    y = haloY;
                    haloRotateSpeed = -haloRotSpeed;

                    shapes = 4;
                    triLength = 0f;
                    triLengthTo = 5f;
                    haloRotation = 45f;
                    haloRadius = 16f;
                    tri = true;
                    radius = 8f;
                }},
                new HaloPart(){{
                    progress = haloProgress;
                    color = Pal.accent;
                    layer = Layer.effect;
                    y = haloY;
                    haloRotateSpeed = -haloRotSpeed;

                    shapes = 4;
                    shapeRotation = 180f;
                    triLength = 0f;
                    triLengthTo = 2f;
                    haloRotation = 45f;
                    haloRadius = 16f;
                    tri = true;
                    radius = 8f;
                }},
                new HaloPart(){{
                    progress = haloProgress;
                    color = Pal.accent;
                    layer = Layer.effect;
                    y = haloY;
                    haloRotateSpeed = haloRotSpeed;

                    shapes = 4;
                    triLength = 0f;
                    triLengthTo = 3f;
                    haloRotation = 45f;
                    haloRadius = 10f;
                    tri = true;
                    radius = 6f;
                }}
                );

                for(int i = 0; i < 3; i++){
                    int fi = i;
                    parts.add(new RegionPart("-blade-bar"){{
                        progress = PartProgress.warmup;
                        heatProgress = PartProgress.warmup;
                        mirror = true;
                        under = true;
                        outline = false;
                        layerOffset = -0.3f;
                        turretHeatLayer = Layer.turret - 0.2f;
                        y = 44f / 4f - fi * 38f / 4f;
                        moveX = 2f;

                        color = Pal.accent;
                    }});
                }

                for(int i = 0; i < 4; i++){
                    int fi = i;
                    parts.add(new RegionPart("-spine"){{
                        progress = PartProgress.warmup.delay(fi / 5f);
                        heatProgress = PartProgress.warmup;
                        mirror = true;
                        under = true;
                        layerOffset = -0.3f;
                        turretHeatLayer = Layer.turret - 0.2f;
                        moveY = -22f / 4f - fi * 3f;
                        moveX = 52f / 4f - fi * 1f + 2f;
                        moveRot = -fi * 30f;

                        color = Pal.accent;
                        moves.add(new PartMove(PartProgress.recoil.delay(fi / 5f), 0f, 0f, 35f));
                    }});
                }
            }};

            shootWarmupSpeed = 0.04f;
            shootY = 15f;
            outlineColor = Pal.darkOutline;
            size = 5;
            envEnabled |= Env.space;
            warmupMaintainTime = 120f;
            reload = 100f;
            recoil = 2f;
            range = 3 * 300;
            trackingRange = range * 1.4f;
            shootCone = 30f;
            scaledHealth = 350;
            rotateSpeed = 1.5f;

            coolant = consume(new ConsumeLiquid(Liquids.water, 15f / 60f));
            limitRange();

            loopSound = Sounds.loopGlow;
            loopSoundVolume = 0.8f;
        }};

        malign = new PowerTurret("malign"){{
            requirements(Category.turret, with(Items.carbide, 200, Items.beryllium, 1000, Items.silicon, 500, Items.graphite, 500, Items.phaseFabric, 200));

            var haloProgress = PartProgress.warmup;
            Color haloColor = Color.valueOf("d370d3"), heatCol = Color.purple;
            float haloY = -15f, haloRotSpeed = 1.5f;

            var circleProgress = PartProgress.warmup.delay(0.9f);
            var circleColor = haloColor;
            float circleY = 25f, circleRad = 11f, circleRotSpeed = 3.5f, circleStroke = 1.6f;

            shootSound = Sounds.shootMalign;
            loopSound = Sounds.loopMalign;
            loopSoundVolume = 1.3f;

            shootType = new FlakBulletType(8f, 70f){{
                sprite = "missile-large";

                lifetime = 40f;
                width = 12f;
                height = 22f;

                hitSize = 7f;
                shootEffect = Fx.shootSmokeSquareBig;
                smokeEffect = Fx.shootSmokeDisperse;
                ammoMultiplier = 1;
                hitColor = backColor = trailColor = lightningColor = circleColor;
                frontColor = Color.white;
                trailWidth = 3f;
                trailLength = 12;
                hitEffect = despawnEffect = Fx.hitBulletColor;
                buildingDamageMultiplier = 0f;

                trailEffect = Fx.colorSpark;
                trailRotation = true;
                trailInterval = 3f;

                homingPower = 0.17f;
                homingDelay = 19f;
                homingRange = 160f;

                explodeRange = 100f;
                explodeDelay = 0f;

                flakInterval = 20f;
                despawnShake = 3f;

                intervalBullet = new LightningBulletType() {{
                    lightningColor = circleColor;
                    lightningCone = 15f;
                    lightningLength = 35;
                    lightningLengthRand = 5;
                    damage = 18f;
                }};

                fragBullet = new LaserBulletType(65f){{
                    colors = new Color[]{haloColor.cpy().a(0.4f), haloColor, Color.white};
                    buildingDamageMultiplier = 0f;
                    width = 19f;
                    hitEffect = Fx.hitLancer;
                    sideAngle = 175f;
                    sideWidth = 1f;
                    sideLength = 40f;
                    lifetime = 22f;
                    drawSize = 400f;
                    length = 120f;
                    pierceCap = 2;
                    optimalLifeFract = 1f;
                }};

                intervalBullets = 1;
                fragSpread = fragRandomSpread = intervalRandomSpread = 0f;
                bulletInterval = 20f;

                splashDamage = 0f;
                hitEffect = Fx.hitSquaresColor;
                collidesGround = true;
            }};

            size = 5;
            drawer = new DrawTurret("reinforced-"){{
                parts.addAll(

                //summoning circle
                new ShapePart(){{
                    progress = circleProgress;
                    color = circleColor;
                    circle = true;
                    hollow = true;
                    stroke = 0f;
                    strokeTo = circleStroke;
                    radius = circleRad;
                    layer = Layer.effect;
                    y = circleY;
                }},

                new ShapePart(){{
                    progress = circleProgress;
                    rotateSpeed = -circleRotSpeed;
                    color = circleColor;
                    sides = 4;
                    hollow = true;
                    stroke = 0f;
                    strokeTo = circleStroke;
                    radius = circleRad - 1f;
                    layer = Layer.effect;
                    y = circleY;
                }},

                //outer squares

                new ShapePart(){{
                    progress = circleProgress;
                    rotateSpeed = -circleRotSpeed;
                    color = circleColor;
                    sides = 4;
                    hollow = true;
                    stroke = 0f;
                    strokeTo = circleStroke;
                    radius = circleRad - 1f;
                    layer = Layer.effect;
                    y = circleY;
                }},

                //inner square
                new ShapePart(){{
                    progress = circleProgress;
                    rotateSpeed = -circleRotSpeed/2f;
                    color = circleColor;
                    sides = 4;
                    hollow = true;
                    stroke = 0f;
                    strokeTo = 2f;
                    radius = 3f;
                    layer = Layer.effect;
                    y = circleY;
                }},

                //spikes on circle
                new HaloPart(){{
                    progress = circleProgress;
                    color = circleColor;
                    tri = true;
                    shapes = 3;
                    triLength = 0f;
                    triLengthTo = 5f;
                    radius = 6f;
                    haloRadius = circleRad;
                    haloRotateSpeed = haloRotSpeed / 2f;
                    shapeRotation = 180f;
                    haloRotation = 180f;
                    layer = Layer.effect;
                    y = circleY;
                }},

                //actual turret
                new RegionPart("-mouth"){{
                    heatColor = heatCol;
                    heatProgress = PartProgress.warmup;

                    moveY = -8f;
                }},
                new RegionPart("-end"){{
                    moveY = 0f;
                }},

                new RegionPart("-front"){{
                    heatColor = heatCol;
                    heatProgress = PartProgress.warmup;

                    mirror = true;
                    moveRot = 33f;
                    moveY = -4f;
                    moveX = 10f;
                }},
                new RegionPart("-back"){{
                    heatColor = heatCol;
                    heatProgress = PartProgress.warmup;

                    mirror = true;
                    moveRot = 10f;
                    moveX = 2f;
                    moveY = 5f;
                }},

                new RegionPart("-mid"){{
                    heatColor = heatCol;
                    heatProgress = PartProgress.recoil;

                    moveY = -9.5f;
                }},

                new ShapePart(){{
                    progress = haloProgress;
                    color = haloColor;
                    circle = true;
                    hollow = true;
                    stroke = 0f;
                    strokeTo = 2f;
                    radius = 10f;
                    layer = Layer.effect;
                    y = haloY;
                }},
                new ShapePart(){{
                    progress = haloProgress;
                    color = haloColor;
                    sides = 3;
                    rotation = 90f;
                    hollow = true;
                    stroke = 0f;
                    strokeTo = 2f;
                    radius = 4f;
                    layer = Layer.effect;
                    y = haloY;
                }},
                new HaloPart(){{
                    progress = haloProgress;
                    color = haloColor;
                    sides = 3;
                    shapes = 3;
                    hollow = true;
                    stroke = 0f;
                    strokeTo = 2f;
                    radius = 3f;
                    haloRadius = 10f + radius/2f;
                    haloRotateSpeed = haloRotSpeed;
                    layer = Layer.effect;
                    y = haloY;
                }},

                new HaloPart(){{
                    progress = haloProgress;
                    color = haloColor;
                    tri = true;
                    shapes = 3;
                    triLength = 0f;
                    triLengthTo = 10f;
                    radius = 6f;
                    haloRadius = 16f;
                    haloRotation = 180f;
                    layer = Layer.effect;
                    y = haloY;
                }},
                new HaloPart(){{
                    progress = haloProgress;
                    color = haloColor;
                    tri = true;
                    shapes = 3;
                    triLength = 0f;
                    triLengthTo = 3f;
                    radius = 6f;
                    haloRadius = 16f;
                    shapeRotation = 180f;
                    haloRotation = 180f;
                    layer = Layer.effect;
                    y = haloY;
                }},

                new HaloPart(){{
                    progress = haloProgress;
                    color = haloColor;
                    sides = 3;
                    tri = true;
                    shapes = 3;
                    triLength = 0f;
                    triLengthTo = 10f;
                    shapeRotation = 180f;
                    radius = 6f;
                    haloRadius = 16f;
                    haloRotateSpeed = -haloRotSpeed;
                    haloRotation = 180f / 3f;
                    layer = Layer.effect;
                    y = haloY;
                }},

                new HaloPart(){{
                    progress = haloProgress;
                    color = haloColor;
                    sides = 3;
                    tri = true;
                    shapes = 3;
                    triLength = 0f;
                    triLengthTo = 4f;
                    radius = 6f;
                    haloRadius = 16f;
                    haloRotateSpeed = -haloRotSpeed;
                    haloRotation = 180f / 3f;
                    layer = Layer.effect;
                    y = haloY;
                }}
                );

                Color heatCol2 = heatCol.cpy().add(0.1f, 0.1f, 0.1f).mul(1.2f);
                for(int i = 1; i < 4; i++){
                    int fi = i;
                    parts.add(new RegionPart("-spine"){{
                        outline = false;
                        progress = PartProgress.warmup.delay(fi / 5f);
                        heatProgress = PartProgress.warmup.add(p -> (Mathf.absin(3f, 0.2f) - 0.2f) * p.warmup);
                        mirror = true;
                        under = true;
                        layerOffset = -0.3f;
                        turretHeatLayer = Layer.turret - 0.2f;
                        moveY = 9f;
                        moveX = 1f + fi * 4f;
                        moveRot = fi * 60f - 130f;

                        color = Color.valueOf("bb68c3");
                        heatColor = heatCol2;
                        moves.add(new PartMove(PartProgress.recoil.delay(fi / 5f), 1f, 0f, 3f));
                    }});
                }
            }};

            velocityRnd = 0.15f;
            heatRequirement = 144f;
            maxHeatEfficiency = 1f;
            warmupMaintainTime = 120f;
            consumePower(40f);
            unitSort = UnitSorts.strongest;
            shoot = new ShootSummon(0f, 0f, circleRad, 20f);

            minWarmup = 0.96f;
            shootWarmupSpeed = 0.08f;

            shootY = circleY - 5f;

            outlineColor = Pal.darkOutline;
            envEnabled |= Env.space;
            reload = 3.5f;
            range = 3 * 410;
            trackingRange = range * 1.4f;
            shootCone = 100f;
            scaledHealth = 370;
            rotateSpeed = 2.6f;
            recoil = 0.5f;
            recoilTime = 30f;
            shake = 3f;
        }};
}
        //endregion
